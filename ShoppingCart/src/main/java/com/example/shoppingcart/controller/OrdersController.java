package com.example.shoppingcart.controller;

import com.example.shoppingcart.DTO.CartItems;
import com.example.shoppingcart.model.Orders;
import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.model.User;
import com.example.shoppingcart.model.orderItems;
import com.example.shoppingcart.repo.OrderItemRepo;
import com.example.shoppingcart.repo.OrdersRepo;
import com.example.shoppingcart.repo.ProductRepo;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersRepo orderRepo;
    @Autowired
    private OrderItemRepo orderItemRepo;
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/checkout")
    public String checkout(HttpSession session) {

        User user = (User) session.getAttribute("loggedUser");
        Map<Long, CartItems> cart =
                (Map<Long, CartItems>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) return "redirect:/cart";

        Orders order = new Orders();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PLACED");

        double total = 0;
        orderRepo.save(order);

        for (CartItems item : cart.values()) {

            orderItems oi = new orderItems();
            oi.setOrder(order);

            Product product = productRepo
                    .findById(item.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            oi.setProduct(product);
            oi.setPrice(item.getProductPrice());
            oi.setQuantity(item.getQuantity());

            total += item.getProductPrice() * item.getQuantity();
            orderItemRepo.save(oi);
        }


        order.setTotalAmount(total);
        orderRepo.save(order);

        session.removeAttribute("cart");
        return "redirect:/orders";
    }

    @GetMapping
    public String myOrders(HttpSession session, Model model) {

        User user = (User) session.getAttribute("loggedUser");


        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute(
                "orders",
                orderRepo.findByUser_UserId(user.getUserId())
        );

        return "user.orders";
    }

    @GetMapping("/{orderId}")
    public String orderDetails(@PathVariable long orderId,
                               HttpSession session,
                               Model model) {

        User user = (User) session.getAttribute("loggedUser");
        if (user == null) {
            return "redirect:/login";
        }

        Orders order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        // 🔐 IMPORTANT: user should see only his orders
        if (!order.getUser().getUserId().equals(user.getUserId())) {
            return "redirect:/orders";
        }

        List<orderItems> items = orderItemRepo.findByOrder(order);

        model.addAttribute("order", order);
        model.addAttribute("items", items);

        return "user.ordersDetails";
    }
}