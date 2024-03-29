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
@Controller
public class TransactionService
{

@Autowired 
private PurchaseOrderRepository purchaseOrderRepository;

@Autowired
private TransactionRepository transactionRepository;

@Autowired
private UserRepository userRepository;

@ResponseBody
@PostMapping("/shopping/app/{userId}/{orderId}/pay")
public ResponseEntity<String> add(@PathVariable Long userId, @PathVariable Long orderId,@RequestParam(name="amount") BigDecimal amount)
{



String jsonResponse="";
Transaction transaction;

Random rand=new Random();
int randomNum=rand.nextInt(10000);

if(!userRepository.existsById(userId))
{
String transactionIdString=String.valueOf(randomNum);
while(transactionIdString.length()<5)
{
transactionIdString="0"+transactionIdString;
}

String transactionId="trans0101"+transactionIdString;





jsonResponse=jsonResponse+"{\r\n";
jsonResponse=jsonResponse+"\"userId\" : "+userId+",\r\n";
jsonResponse=jsonResponse+"\"orderId\" : "+orderId+",\r\n";
jsonResponse=jsonResponse+"\"transactionId\" : \""+transactionId+"\",\r\n";
jsonResponse=jsonResponse+"\"status\" : \"failed\",\r\n";
jsonResponse=jsonResponse+"\"description\" : \"Payment Failed due to invalid user id\"\r\n";
jsonResponse=jsonResponse+"}\r\n";



return new ResponseEntity<>(jsonResponse,HttpStatus.BAD_REQUEST);

}


if(!purchaseOrderRepository.existsById(orderId))
{
// 400
// Payment Failed due to invalid order id


String transactionIdString=String.valueOf(randomNum);
while(transactionIdString.length()<5)
{
transactionIdString="0"+transactionIdString;
}

String transactionId="trans0101"+transactionIdString;





jsonResponse=jsonResponse+"{\r\n";
jsonResponse=jsonResponse+"\"userId\" : "+userId+",\r\n";
jsonResponse=jsonResponse+"\"orderId\" : "+orderId+",\r\n";
jsonResponse=jsonResponse+"\"transactionId\" : \""+transactionId+"\",\r\n";
jsonResponse=jsonResponse+"\"status\" : \"failed\",\r\n";
jsonResponse=jsonResponse+"\"description\" : \"Payment Failed due to invalid order id\"\r\n";
jsonResponse=jsonResponse+"}\r\n";



return new ResponseEntity<>(jsonResponse,HttpStatus.BAD_REQUEST);

}

Optional<PurchaseOrder> purchaseOrderResult=purchaseOrderRepository.findById(orderId);
PurchaseOrder purchaseOrder=null;
if(purchaseOrderResult.isPresent()) purchaseOrder=purchaseOrderResult.get();




if(purchaseOrder.getTotalAmount().compareTo(amount)!=0)
{
// 400
// Payment Failed as amount is invalid

transaction=new Transaction(purchaseOrder,false);
transactionRepository.save(transaction);


String transactionIdString=String.valueOf(transaction.getId());
while(transactionIdString.length()<5)
{
transactionIdString="0"+transactionIdString;
}

String transactionId="trans0101"+transactionIdString;




jsonResponse=jsonResponse+"{\r\n";
jsonResponse=jsonResponse+"\"userId\" : "+userId+",\r\n";
jsonResponse=jsonResponse+"\"orderId\" : "+orderId+",\r\n";
jsonResponse=jsonResponse+"\"transactionId\" : \""+transactionId+"\",\r\n";
jsonResponse=jsonResponse+"\"status\" : \"failed\",\r\n";
jsonResponse=jsonResponse+"\"description\" : \"Payment Failed as amount is invalid\"\r\n";
jsonResponse=jsonResponse+"}\r\n";



return new ResponseEntity<>(jsonResponse,HttpStatus.BAD_REQUEST);
}
if(randomNum%5==0)
{
// 400
// Payment Failed from bank


transaction=new Transaction(purchaseOrder,false);
transactionRepository.save(transaction);


String transactionIdString=String.valueOf(transaction.getId());
while(transactionIdString.length()<5)
{
transactionIdString="0"+transactionIdString;
}

String transactionId="trans0101"+transactionIdString;




jsonResponse=jsonResponse+"{\r\n";
jsonResponse=jsonResponse+"\"userId\" : "+userId+",\r\n";
jsonResponse=jsonResponse+"\"orderId\" : "+orderId+",\r\n";
jsonResponse=jsonResponse+"\"transactionId\" : \""+transactionId+"\",\r\n";
jsonResponse=jsonResponse+"\"status\" : \"failed\",\r\n";
jsonResponse=jsonResponse+"\"description\" : \"Payment Failed from bank\"\r\n";
jsonResponse=jsonResponse+"}\r\n";

return new ResponseEntity<>(jsonResponse,HttpStatus.BAD_REQUEST);

}


List<Transaction> transactions=transactionRepository.findAllByPurchaseOrder(purchaseOrder);

for(Transaction t:transactions)
{
if(t.getStatus())
{
// 405
//order is already paid for 

transaction=new Transaction(purchaseOrder,false);
transactionRepository.save(transaction);


String transactionIdString=String.valueOf(transaction.getId());
while(transactionIdString.length()<5)
{
transactionIdString="0"+transactionIdString;
}

String transactionId="trans0101"+transactionIdString;




jsonResponse=jsonResponse+"{\r\n";
jsonResponse=jsonResponse+"\"userId\" : "+userId+",\r\n";
jsonResponse=jsonResponse+"\"orderId\" : "+orderId+",\r\n";
jsonResponse=jsonResponse+"\"transactionId\" : \""+transactionId+"\",\r\n";
jsonResponse=jsonResponse+"\"status\" : \"failed\",\r\n";
jsonResponse=jsonResponse+"\"description\" : \"Order is already paid for\"\r\n";
jsonResponse=jsonResponse+"}\r\n";



return new ResponseEntity<>(jsonResponse,HttpStatus.METHOD_NOT_ALLOWED);
}


}




if(randomNum%7==0)
{
// 504
// No response from payment server

transaction=new Transaction(purchaseOrder,false);
transactionRepository.save(transaction);


String transactionIdString=String.valueOf(transaction.getId());
while(transactionIdString.length()<5)
{
transactionIdString="0"+transactionIdString;
}

String transactionId="trans0101"+transactionIdString;




jsonResponse=jsonResponse+"{\r\n";
jsonResponse=jsonResponse+"\"userId\" : "+userId+",\r\n";
jsonResponse=jsonResponse+"\"orderId\" : "+orderId+",\r\n";
jsonResponse=jsonResponse+"\"transactionId\" : \""+transactionId+"\",\r\n";
jsonResponse=jsonResponse+"\"status\" : \"failed\",\r\n";
jsonResponse=jsonResponse+"\"description\" : \"No response from payment server\"\r\n";
jsonResponse=jsonResponse+"}\r\n";


return new ResponseEntity<>(jsonResponse,HttpStatus.GATEWAY_TIMEOUT);


}

transaction=new Transaction(purchaseOrder,true);
transactionRepository.save(transaction);





String transactionIdString=String.valueOf(transaction.getId());
while(transactionIdString.length()<5)
{
transactionIdString="0"+transactionIdString;
}

String transactionId="trans0101"+transactionIdString;




jsonResponse=jsonResponse+"{\r\n";
jsonResponse=jsonResponse+"\"userId\" : "+userId+",\r\n";
jsonResponse=jsonResponse+"\"orderId\" : "+orderId+",\r\n";
jsonResponse=jsonResponse+"\"transactionId\" : \""+transactionId+"\",\r\n";
jsonResponse=jsonResponse+"\"status\" : \"successful\",\r\n";
jsonResponse=jsonResponse+"}\r\n";

return new ResponseEntity<>(jsonResponse,HttpStatus.OK);


}

}
