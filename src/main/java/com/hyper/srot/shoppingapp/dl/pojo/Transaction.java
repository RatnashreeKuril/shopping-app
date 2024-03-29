package com.hyper.srot.shoppingapp.dl.pojo;
import jakarta.persistence.*;
@Entity(name="transaction")
public class Transaction
{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="id")
private Long id;
@ManyToOne()
@JoinColumn(name="order_id", referencedColumnName="id")
private PurchaseOrder purchaseOrder;
@Column(name="status")
private Boolean status;
public Transaction()
{
}
public Transaction(PurchaseOrder purchaseOrder,Boolean status)
{
this.purchaseOrder=purchaseOrder;
this.status=status;
}
public void setId(Long id)
{
this.id=id;
}
public Long getId()
{
return this.id;
}
public void setPurchaseOrder(PurchaseOrder purchaseOrder)
{
this.purchaseOrder=purchaseOrder;
}
public PurchaseOrder getPurchaseOrder()
{
return this.purchaseOrder;
}
public void setStatus(Boolean status)
{
this.status=status;
}
public Boolean getStatus()
{
return this.status;
}
}
