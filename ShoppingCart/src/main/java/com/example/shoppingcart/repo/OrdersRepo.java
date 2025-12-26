package com.example.shoppingcart.repo;
import com.example.shoppingcart.model.Orders;

import com.example.shoppingcart.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Long> {

    List<Orders> findByUser(User user);
    List<Orders> findByUserOrderByOrderDateDesc(User user);
    List<Orders> findByUser_UserId(Long userId);

}
