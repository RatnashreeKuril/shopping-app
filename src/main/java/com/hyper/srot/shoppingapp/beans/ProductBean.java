package com.hyper.srot.shoppingapp.beans;
import java.math.*;
import com.fasterxml.jackson.annotation.*;
public class ProductBean implements java.io.Serializable
{
@JsonInclude(value=JsonInclude.Include.NON_NULL)
private Long code;
@JsonInclude(value=JsonInclude.Include.NON_NULL)
private String name;
private BigDecimal price;
private Long available;
private Long ordered;
public ProductBean()
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
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public void setPrice(BigDecimal price)
{
this.price=price;
}
public BigDecimal getPrice()
{
return this.price;
}
public void setAvailable(Long available)
{
this.available=available;
}
public Long getAvailable()
{
return this.available;
}
public void setOrdered(Long ordered)
{
this.ordered=ordered;
}
public Long getOrdered()
{
return this.ordered;
}
}