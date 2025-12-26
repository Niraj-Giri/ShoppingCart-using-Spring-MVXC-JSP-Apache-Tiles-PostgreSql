package com.example.shoppingcart.repo;

import com.example.shoppingcart.model.Orders;
import com.example.shoppingcart.model.orderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepo extends JpaRepository<orderItems, Long> {

    // Get all items of a particular order
    List<orderItems> findByOrder(Orders order);
}