package com.hyper.srot.shoppingapp.dl.pojo;
import jakarta.persistence.*;
import java.math.*;
@Entity(name="coupon")
public class Coupon implements java.io.Serializable
{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="code")
private Long code;
@Column(name="name")
private String name;
@Column(name="discount")
private BigDecimal discount;
public Coupon()
{

}
public Coupon(String name, BigDecimal discount)
{
this.name=name;
this.discount=discount;
}
public void setCode(Long code)
{
this.code=code;
}
public Long getCode()
{
return this.code;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public void setDiscount(BigDecimal discount)
{
this.discount=discount;
}
public BigDecimal getDiscount()
{
return this.discount;
}

}