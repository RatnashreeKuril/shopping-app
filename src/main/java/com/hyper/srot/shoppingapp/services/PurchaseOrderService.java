package com.hyper.srot.shoppingapp.services;
import com.hyper.srot.shoppingapp.beans.*;
import com.hyper.srot.shoppingapp.dl.*;
import com.hyper.srot.shoppingapp.dl.pojo.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.dao.*;
import org.springframework.http.*;
import java.util.*;
import java.math.*;
import java.time.format.*;
import java.time.*;
import java.text.*;
@Controller
public class PurchaseOrderService
{
@Autowired
private PurchaseOrderRepository purchaseOrderRepository;

@Autowired
private UserRepository userRepository;

@Autowired
private InventoryBean inventoryBean;

@Autowired
private ProductRepository productRepository;

@Autowired
private CouponRepository couponRepository;

@Autowired
private TransactionRepository transactionRepository;

@Autowired
private AvailableCouponRepository availableCouponRepository;

@ResponseBody
@PostMapping("/shopping/app/{userId}/order")
public ResponseEntity<String> add(@PathVariable Long userId,@RequestParam(name="qty") Long quantity, @RequestParam(name="coupon") String couponName)
{
String jsonResponse;
if(!userRepository.existsById(userId))
{
jsonResponse="{\"description\" : \"Invalid user id : "+userId+"\"}";
return new ResponseEntity<>(jsonResponse,HttpStatus.NOT_FOUND);
}
Optional<User> userResult=userRepository.findById(userId);
User user=null;
if(userResult.isPresent()) user=userResult.get();


if(quantity<=0 || quantity>inventoryBean.getAvailable())
{
jsonResponse="{\"description\" : \"Invalid quantity\"}";
return new ResponseEntity<>(jsonResponse,HttpStatus.NOT_FOUND);
}


Coupon coupon=couponRepository.findByName(couponName);

if(coupon==null)
{
jsonResponse="{\"description\" : \"Invalid coupon\"}";
return new ResponseEntity<>(jsonResponse,HttpStatus.NOT_FOUND);
}
Long couponCode=coupon.getCode();
BigDecimal discount=coupon.getDiscount();
AvailableCouponKey key=new AvailableCouponKey();
key.setUserId(userId);
key.setCouponCode(couponCode);
AvailableCoupon availableCoupon=availableCouponRepository.findByAvailableCouponKey(key);
AvailableCouponKey availableCouponKey=availableCoupon.getAvailableCouponKey();

if(!availableCoupon.getIsAvailable())
{
jsonResponse="{\"description\" : \"Invalid coupon\"}";
return new ResponseEntity<>(jsonResponse,HttpStatus.NOT_FOUND);
}
availableCoupon.setIsAvailable(false);
availableCouponRepository.save(availableCoupon);


java.util.Date utilOrderDate=new java.util.Date();


java.sql.Date sqlOrderDate=new java.sql.Date(utilOrderDate.getYear(),utilOrderDate.getMonth(),utilOrderDate.getDate());
BigDecimal totalAmount=inventoryBean.getPrice().multiply(BigDecimal.valueOf(quantity));
totalAmount=totalAmount.subtract((totalAmount.multiply(discount.divide(new BigDecimal("100")))));
PurchaseOrder purchaseOrder=new PurchaseOrder(sqlOrderDate,user,coupon,totalAmount);
purchaseOrderRepository.save(purchaseOrder);
jsonResponse="";
jsonResponse+="{\r\n";
jsonResponse+="\"orderId\" : "+purchaseOrder.getId()+",\r\n";
jsonResponse+="\"userId\" : "+userId+",\r\n";
jsonResponse+="\"quantity\" : "+quantity+",\r\n";
jsonResponse+="\"amount\" : "+totalAmount+",\r\n";
jsonResponse+="\"coupon\" : \""+coupon.getName()+"\"\r\n";
jsonResponse+="}";

return new ResponseEntity<>(jsonResponse,HttpStatus.OK);


}

@ResponseBody
@GetMapping("shopping/app/{userId}/orders")
public ResponseEntity<String> getAll()
{

java.lang.Iterable<PurchaseOrder> purchaseOrders=purchaseOrderRepository.findAll();
String jsonResponse="";
Long orderId;
String amount,couponName;
Coupon coupon;
for(PurchaseOrder purchaseOrder:purchaseOrders)
{
orderId=purchaseOrder.getId();
amount=purchaseOrder.getTotalAmount().toPlainString();
coupon=purchaseOrder.getCoupon();
couponName=coupon.getName();
java.sql.Date sqlOrderDate=purchaseOrder.getOrderDate();

SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
String orderDateString=simpleDateFormat.format(sqlOrderDate);

jsonResponse=jsonResponse+"{\"orderId\" : "+orderId+", \"amount\" : "+amount+", \"date\" : \""+orderDateString+"\",\"coupon\" : \""+couponName+"\"}\r\n";

}



return new ResponseEntity<String>(jsonResponse,HttpStatus.OK);
}

@ResponseBody
@GetMapping("shopping/app/{userId}/orders/{orderId}")
public ResponseEntity<String> getByOrderId(@PathVariable Long userId, @PathVariable Long orderId)
{

String jsonResponse="";

if(!purchaseOrderRepository.existsById(orderId))
{

jsonResponse=jsonResponse+"{\r\n";
jsonResponse=jsonResponse+"\"orderId\" : "+orderId+",\r\n";
jsonResponse=jsonResponse+"\"description\" : \"Order not found\"\r\n";
jsonResponse=jsonResponse+"}\r\n";
return new ResponseEntity<String>(jsonResponse,HttpStatus.NOT_FOUND);
}

Optional<PurchaseOrder> purchaseOrderResult=purchaseOrderRepository.findById(orderId);
PurchaseOrder purchaseOrder=null;
if(purchaseOrderResult.isPresent()) purchaseOrder=purchaseOrderResult.get();

String amount=purchaseOrder.getTotalAmount().toPlainString();
java.sql.Date sqlOrderDate=purchaseOrder.getOrderDate();
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
String orderDateString=simpleDateFormat.format(sqlOrderDate);
String couponName=purchaseOrder.getCoupon().getName();
String status;
List<Transaction> transactions=transactionRepository.findAllByPurchaseOrder(purchaseOrder);
Long id;
String idString;
String transactionId;
for(Transaction transaction:transactions)
{
status=(transaction.getStatus()==true)?"successful":"failed";

id=transaction.getId();
idString=String.valueOf(id);
while(idString.length()<5)
{
idString="0"+idString;
}
transactionId="tran0101"+idString;

jsonResponse=jsonResponse+"{";
jsonResponse=jsonResponse+"\"orderId\" : "+orderId+",";
jsonResponse=jsonResponse+"\"amount\" : "+amount+",";
jsonResponse=jsonResponse+"\"date\" : \""+orderDateString+"\",";
jsonResponse=jsonResponse+"\"coupon\" : \""+couponName+"\",";
jsonResponse=jsonResponse+"\"transactionId\" : \""+transactionId+"\",";
jsonResponse=jsonResponse+"\"status\" : \""+status+"\"";
jsonResponse=jsonResponse+"}\r\n";

}

return new ResponseEntity<String>(jsonResponse,HttpStatus.OK);
}




}
