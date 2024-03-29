package com.hyper.srot.shoppingapp.dl.pojo;
import jakarta.persistence.*;
import java.math.*;
@Entity(name="purchase_order")
public class PurchaseOrder implements java.io.Serializable
{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="id")
private Long id;
@Column(name="orderDate")
private java.sql.Date orderDate;
@ManyToOne()
@JoinColumn(name="user_id",referencedColumnName="id")
private User user;
@OneToOne()
@JoinColumn(name="coupon_code",referencedColumnName="code")
private Coupon coupon;
@Column(name="totalAmount")
private BigDecimal totalAmount;
public PurchaseOrder()
{
}
public PurchaseOrder(java.sql.Date orderDate, User user, Coupon coupon,BigDecimal totalAmount)
{
this.orderDate=orderDate;
this.user=user;
this.coupon=coupon;
this.totalAmount=totalAmount;
}
public void setId(Long id)
{
this.id=id;
}
public Long getId()
{
return this.id;
}
public void setOrderDate(java.sql.Date orderDate)
{
this.orderDate=orderDate;
}
public java.sql.Date getOrderDate()
{
return this.orderDate;
}
public void setUser(User user)
{
this.user=user;
}
public User getUser()
{
return this.user;
}
public void setCoupon(Coupon coupon)
{
this.coupon=coupon;
}
public Coupon getCoupon()
{
return this.coupon;
}
public void setTotalAmount(BigDecimal totalAmount)
{
this.totalAmount=totalAmount;
}
public BigDecimal getTotalAmount()
{
return this.totalAmount;
}
}