package com.hyper.srot.shoppingapp.dl.pojo;
import jakarta.persistence.*;
import java.math.*;
@Entity(name="available_coupon")
public class AvailableCoupon implements java.io.Serializable
{
@EmbeddedId
private AvailableCouponKey availableCouponKey;
@Column(name="is_available")
private Boolean isAvailable;
public AvailableCoupon()
{

}
public void setAvailableCouponKey(AvailableCouponKey availableCouponKey)
{
this.availableCouponKey=availableCouponKey;
}
public AvailableCouponKey getAvailableCouponKey()
{
return this.availableCouponKey;
}
public void setIsAvailable(Boolean isAvailable)
{
this.isAvailable=isAvailable;
}
public Boolean getIsAvailable()
{
return this.isAvailable;
}
}