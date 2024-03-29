package com.hyper.srot.shoppingapp.beans;
import java.math.*;
public class AvailableCouponBean implements java.io.Serializable
{
private Long code;
private Boolean isAvailable;
public AvailableCouponBean()
{
}
public void setCode(Long code)
{
this.code=code;
}
public Long getCode()
{
return this.code;
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
