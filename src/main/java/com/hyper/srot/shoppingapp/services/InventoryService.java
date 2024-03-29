package com.hyper.srot.shoppingapp.services;
import com.hyper.srot.shoppingapp.beans.*;
import com.hyper.srot.shoppingapp.dl.*;
import com.hyper.srot.shoppingapp.dl.pojo.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.dao.*;
import java.util.*;
@Controller
public class InventoryService
{
@Autowired
private InventoryBean inventoryBean;
@ResponseBody
@GetMapping("/shopping/app/inventory")
public InventoryBean getAll()
{
return inventoryBean;
}


}
