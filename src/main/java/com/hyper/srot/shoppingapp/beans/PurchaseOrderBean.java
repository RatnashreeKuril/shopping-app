package com.hyper.srot.shoppingapp.beans;
import org.springframework.format.annotation.*;
import java.math.*;
import java.util.*;
public class PurchaseOrderBean implements java.io.Serializable
{
private Long id;
@DateTimeFormat(pattern="yyyy-MM-dd")
private java.util.Date orderDate;
private Long userId;
private List<PurchaseOrderItemBean> items;
private BigDecimal amount;
private Long couponCode;
public PurchaseOrderBean()
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
public void setOrderDate(java.util.Date orderDate)
{
this.orderDate=orderDate;
}
public java.util.Date getOrderDate()
{
return this.orderDate;
}
public void setUserId(Long userId)
{
this.userId=userId;
}
public Long getUserId()
{
return this.userId;
}
public void setItems(List<PurchaseOrderItemBean> items)
{
this.items=items;
}
public List<PurchaseOrderItemBean> getItems()
{
return this.items;
}
public void setAmount(BigDecimal amount)
{
this.amount=amount;
}
public BigDecimal getAmount()
{
return this.amount;
}
public void setCouponCode(Long couponCode)
{
this.couponCode=couponCode;
}
public Long getCouponCode()
{
return this.couponCode;
}
}