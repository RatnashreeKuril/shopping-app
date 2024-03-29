package com.hyper.srot.shoppingapp.dl;
import com.hyper.srot.shoppingapp.dl.pojo.*;
import org.springframework.data.repository.*;
public interface UserRepository extends CrudRepository<User,Long>
{
public User findByEmailId(String emailId);
}