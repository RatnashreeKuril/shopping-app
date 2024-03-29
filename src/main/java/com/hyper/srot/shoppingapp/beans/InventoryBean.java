package com.hyper.srot.shoppingapp.beans;
import org.springframework.format.annotation.*;
import java.util.*;
import java.math.*;
public class InventoryBean implements java.io.Serializable
{
private Long ordered;
private BigDecimal price;
private Long available;
public InventoryBean()
{
}
public void setOrdered(Long ordered)
{
this.ordered=ordered;
}
public Long getOrdered()
{
return this.ordered;
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
}
