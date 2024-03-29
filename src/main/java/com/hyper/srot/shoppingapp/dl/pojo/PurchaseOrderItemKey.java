package com.hyper.srot.shoppingapp.dl.pojo;
import jakarta.persistence.*;
import java.util.*;
@Embeddable
public class PurchaseOrderItemKey implements java.io.Serializable
{
@Column(name="order_id")
private Long orderId;
@Column(name="product_code")
private Long productCode;
public PurchaseOrderItemKey()
{
}
public void setOrderId(Long orderId)
{
this.orderId=orderId;
}
public Long getOrderId()
{
return this.orderId;
}
public void setProductCode(Long productCode)
{
this.productCode=productCode;
}

public Long getProductCode()
{
return this.productCode;
}
// it is necc to write equals and hashCode method
public boolean equals(Object other)
{
if(!(other instanceof PurchaseOrderItemKey)) return false;
PurchaseOrderItemKey purchaseOrderItemKey;
purchaseOrderItemKey=(PurchaseOrderItemKey)other;
return purchaseOrderItemKey.orderId.equals(this.orderId) && purchaseOrderItemKey.productCode.equals(this.productCode);
}
public int hashCode()
{
return Objects.hash(this.orderId,this.productCode);
}


}
