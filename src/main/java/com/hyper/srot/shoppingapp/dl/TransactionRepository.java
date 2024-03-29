package com.hyper.srot.shoppingapp.dl;
import com.hyper.srot.shoppingapp.dl.pojo.*;
import org.springframework.data.repository.*;
import java.util.*;
public interface TransactionRepository extends CrudRepository<Transaction,Long>
{
public Transaction findByPurchaseOrder(PurchaseOrder purchaseOrder);
public List<Transaction> findAllByPurchaseOrder(PurchaseOrder purchaseOrder);
}