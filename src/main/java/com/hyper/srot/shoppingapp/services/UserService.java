package com.hyper.srot.shoppingapp.services;
import com.hyper.srot.shoppingapp.beans.*;
import com.hyper.srot.shoppingapp.dl.*;
import com.hyper.srot.shoppingapp.dl.pojo.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.dao.*;
import java.util.*;
import java.math.*;
@Controller
public class UserService
{
@Autowired
private UserRepository userRepository;

@ResponseBody
@PostMapping("shopping/app/addUser")
public UserBean addUser(UserBean userBean)
{
String name=userBean.getName();
String emailId=userBean.getEmailId();
String password=userBean.getPassword();
String passwordKey=java.util.UUID.randomUUID().toString().replaceAll("-","d");
String encryptedPassword=password; // as of now, we are not encrypting
java.util.Date dateOfRegistration=userBean.getDateOfRegistration();
java.sql.Date sqlDateOfRegistration=new java.sql.Date(dateOfRegistration.getYear(),dateOfRegistration.getMonth(),dateOfRegistration.getDate());

User user=new User(name,emailId,password,passwordKey,sqlDateOfRegistration);
userRepository.save(user);
userBean.setId(user.getId());
userBean.setPassword(null);
return userBean;
}

@ResponseBody
@PostMapping("shopping/app/getUserByEmailId")
public UserBean getUserByEmailId(@RequestParam("emailId") String emailId)
{
User user=userRepository.findByEmailId(emailId);
if(user==null) return null;
UserBean userBean=new UserBean();
userBean.setId(user.getId());
userBean.setName(user.getName());
userBean.setEmailId(user.getEmailId());
java.sql.Date sqlDateOfRegistration=user.getDateOfRegistration();
java.util.Date utilDateOfRegistration=new java.util.Date(sqlDateOfRegistration.getYear(),sqlDateOfRegistration.getMonth(),sqlDateOfRegistration.getDate());
userBean.setDateOfRegistration(utilDateOfRegistration);
return userBean;
}



}
