package com.hyper.srot.shoppingapp.dl.pojo;
import jakarta.persistence.*;
import java.math.*;
@Entity(name="product")
public class Product
{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="code")
private Long code;
@Column(name="name")
private String name;
@Column(name="price")
private BigDecimal price;
@Column(name="available_quantity")
private Long availableQuantity;
public Product()
{
}
public Product(String name,BigDecimal price,Long availableQuantity)
{
this.name=name;
this.price=price;
this.availableQuantity=availableQuantity;
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
public void setAvailableQuantity(Long availableQuantity)
{
this.availableQuantity=availableQuantity;
}
public Long getAvailableQuantity()
{
return this.availableQuantity;
}


}
