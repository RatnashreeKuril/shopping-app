package com.hyper.srot.shoppingapp.dl.pojo;
import jakarta.persistence.*;
import java.math.*;
@Entity(name="purchase_order_item")
public class PurchaseOrderItem implements java.io.Serializable
{
@EmbeddedId
private PurchaseOrderItemKey purchaseOrderItemKey;
@Column(name="quantity")
private Integer quantity;
@Column(name="price")
private BigDecimal price;
public PurchaseOrderItem()
{

}
public void setPurchaseOrderItemKey(PurchaseOrderItemKey purchaseOrderItemKey)
{
this.purchaseOrderItemKey=purchaseOrderItemKey;
}
public PurchaseOrderItemKey getPurchaseOrderItemKey()
{
return this.purchaseOrderItemKey;
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