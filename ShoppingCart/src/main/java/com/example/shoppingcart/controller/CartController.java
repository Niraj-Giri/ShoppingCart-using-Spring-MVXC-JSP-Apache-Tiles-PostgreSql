package com.example.shoppingcart.controller;

import com.example.shoppingcart.DTO.CartItems;
import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.repo.ProductRepo;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/add")
    public String addToCart(@RequestParam Long productId,
                            HttpSession session,
                            Model model) {

        Map<Long, CartItems> cart =
                (Map<Long, CartItems>) session.getAttribute("cart");

        if (cart == null) {
            cart = new HashMap<>();
        }

        if (cart.containsKey(productId)) {
            CartItems item = cart.get(productId);
            item.setQuantity(item.getQuantity() + 1);
        } else {
            Product p = productRepo.findById(Math.toIntExact(productId)).orElseThrow();
            cart.put(productId,
                    new CartItems(p.getProductId(), p.getProductName(), p.getProductPrice(), p.getImage()));
        }

        session.setAttribute("cart", cart);
        session.setAttribute("msg", "Product added to cart");

        return "redirect:/home";
    }

    @GetMapping
    public String viewCart(HttpSession session, Model model) {
        Map<Long, CartItems> cart =
                (Map<Long, CartItems>) session.getAttribute("cart");

        model.addAttribute("cart", cart);
        return "user.cart";
    }

    @GetMapping("/remove")
    public String removeItem(@RequestParam Long productId, HttpSession session) {
        Map<Long, CartItems> cart =
                (Map<Long, CartItems>) session.getAttribute("cart");

        if (cart != null) {
            cart.remove(productId);
        }
        return "redirect:/cart";
    }
}