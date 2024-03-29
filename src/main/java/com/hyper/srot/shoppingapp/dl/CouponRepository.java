package com.hyper.srot.shoppingapp.dl;
import com.hyper.srot.shoppingapp.dl.pojo.*;
import org.springframework.data.repository.*;
public interface CouponRepository extends CrudRepository<Coupon,Long>
{
public Coupon findByName(String name);
}