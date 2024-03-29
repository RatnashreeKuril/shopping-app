package com.hyper.srot.shoppingapp.beans;
import org.springframework.format.annotation.*;
import java.util.*;
public class UserBean implements java.io.Serializable
{
private Long id;
private String name;
private String emailId;
private String password;
@DateTimeFormat(pattern="yyyy-MM-dd")
private java.util.Date dateOfRegistration;
private List<AvailableCouponBean> availableCoupons;
public UserBean()
{
}
public void setId(Long id)
{
this.id=id;
}
public Long getId()
{
return this.id;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public void setEmailId(String emailId)
{
this.emailId=emailId;
}
public String getEmailId()
{
return this.emailId;
}
public void setPassword(String password)
{
this.password=password;
}
public String getPassword()
{
return this.password;
}
public void setDateOfRegistration(java.util.Date dateOfRegistration)
{
this.dateOfRegistration=dateOfRegistration;
}
public java.util.Date getDateOfRegistration()
{
return this.dateOfRegistration;
}
public void setAvailableCoupons(List<AvailableCouponBean> availableCoupons)
{
this.availableCoupons=availableCoupons;
}
public List<AvailableCouponBean> getAvailableCoupons()
{
return this.availableCoupons;
}
}
