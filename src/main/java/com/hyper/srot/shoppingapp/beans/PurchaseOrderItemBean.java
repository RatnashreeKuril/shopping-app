package com.hyper.srot.shoppingapp.beans;
import java.math.*;
public class PurchaseOrderItemBean implements java.io.Serializable
{

private Long productCode;
private Integer quantity;
private BigDecimal price;
public PurchaseOrderItemBean()
{

}


public void setProductCode(Long productCode)
{
this.productCode=productCode;
}
public Long getProductCode()
{
return this.productCode;
}
public void setQuantity(Integer quantity)
{
this.quantity=quantity;
}
public Integer getQuantity()
{
return this.quantity;
}
public void setPrice(BigDecimal price)
{
this.price=price;
}
public BigDecimal getPrice()
{
return this.price;
}
}
