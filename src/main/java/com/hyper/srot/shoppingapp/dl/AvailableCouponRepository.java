package com.hyper.srot.shoppingapp.dl;
import com.hyper.srot.shoppingapp.dl.pojo.*;
import org.springframework.data.repository.*;
public interface AvailableCouponRepository extends CrudRepository<AvailableCoupon,AvailableCouponKey>
{
public AvailableCoupon findByAvailableCouponKey(AvailableCouponKey availableCouponKey);
}