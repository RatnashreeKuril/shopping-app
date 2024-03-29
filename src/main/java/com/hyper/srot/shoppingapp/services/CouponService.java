package com.hyper.srot.shoppingapp.services;
import com.hyper.srot.shoppingapp.beans.*;
import com.hyper.srot.shoppingapp.dl.*;
import com.hyper.srot.shoppingapp.dl.pojo.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.dao.*;
import java.util.*;
import java.math.*;
@Controller
public class CouponService
{
@Autowired
private CouponRepository couponRepository;
@ResponseBody
@GetMapping("/shopping/app/fetchCoupons")
public Map<String,BigDecimal> getAll()
{
ArrayList<Coupon> coupons=new ArrayList<>();
Map<String,BigDecimal> couponsMap=new HashMap<>();

couponRepository.findAll().forEach(coupon->{
String name=coupon.getName();
BigDecimal discount=coupon.getDiscount();
couponsMap.put(name,discount);
});


return couponsMap;
}


}
