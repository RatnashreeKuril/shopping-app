package com.hyper.srot.shoppingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import com.hyper.srot.shoppingapp.beans.*;
import com.google.gson.*;
import java.io.*;
@SpringBootApplication
public class ShoppingappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingappApplication.class, args);
	}
@Bean
public InventoryBean getInventoryBean()
{
System.out.println("getInventoryBean got called");
InventoryBean inventoryBean=null;
try
{
File file=new File("conf"+File.separator+"inventory.json");
if(file.exists())
{
Gson gson=new Gson();
inventoryBean=gson.fromJson(new FileReader(file.getAbsolutePath()),InventoryBean.class);
}
else
{
inventoryBean=new InventoryBean();
}
}catch(Exception exception)
{
System.out.println(exception); // later on it should be logged somewhere
}
return inventoryBean;
}

}
