package com.hyper.srot.shoppingapp.dl.pojo;
import jakarta.persistence.*;
import java.util.*;
@Embeddable
public class AvailableCouponKey implements java.io.Serializable
{
@Column(name="user_id")
private Long userId;
@Column(name="coupon_code")
private Long couponCode;
public AvailableCouponKey()
{
}
public void setUserId(Long userId)
{
this.userId=userId;
}
public Long getUserId()
{
return this.userId;
}
public void setCouponCode(Long couponCode)
{
this.couponCode=couponCode;
}

public Long getCouponCode()
{
return this.couponCode;
}
// it is necc to write equals and hashCode method
public boolean equals(Object other)
{
if(!(other instanceof AvailableCouponKey)) return false;
AvailableCouponKey availableCouponKey;
availableCouponKey=(AvailableCouponKey)other;
return availableCouponKey.userId.equals(this.userId) && availableCouponKey.couponCode.equals(this.couponCode);
}
public int hashCode()
{
return Objects.hash(this.userId,this.couponCode);
}


}
