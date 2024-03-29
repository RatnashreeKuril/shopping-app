package com.hyper.srot.shoppingapp.dl.pojo;
import jakarta.persistence.*;
@Entity(name="user")
public class User
{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="id")
private Long id;
@Column(name="name")
private String name;
@Column(name="email_id",unique=true)
private String emailId;
@Column(name="password")
private String password;
@Column(name="password_key")
private String passwordKey;
@Column(name="date_of_registration")
private java.sql.Date dateOfRegistration;
public User()
{
}
public User(String name,String emailId,String password,String passwordKey,java.sql.Date dateOfRegistration)
{
this.name=name;
this.emailId=emailId;
this.password=password;
this.passwordKey=passwordKey;
this.dateOfRegistration=dateOfRegistration;
}
public void setId(Long id)
{
this.id=id;
}
public Long getId()
{
return this.id;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public void setEmailId(String emailId)
{
this.emailId=emailId;
}
public String getEmailId()
{
return this.emailId;
}
public void setPassword(String password)
{
this.password=password;
}
public String setPassword()
{
return this.password;
}
public void setPasswordKey(String passwordKey)
{
this.passwordKey=passwordKey;
}
public String getPasswordKey()
{
return this.passwordKey;
}
public void setDateOfRegistration(java.sql.Date dateOfRegistration)
{
this.dateOfRegistration=dateOfRegistration;
}
public java.sql.Date getDateOfRegistration()
{
return this.dateOfRegistration;
}

}
