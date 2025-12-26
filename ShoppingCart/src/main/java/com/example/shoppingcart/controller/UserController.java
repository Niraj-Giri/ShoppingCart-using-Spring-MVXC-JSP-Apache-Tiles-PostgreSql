package com.example.shoppingcart.controller;
import com.example.shoppingcart.DTO.CartItems;
import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.model.User;
import com.example.shoppingcart.service.ProductService;
import com.example.shoppingcart.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;


@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    // Show registration page
    @GetMapping("/register")
    public String showRegisterPage() {
        return "user.register";
    }

    // Handle registration
    @PostMapping("/register")
    public String registerUser(User user, Model model) {
         System.out.println("hello");
        // Check email already exists
        if (userService.emailExists(user.getEmail())) {
            model.addAttribute("error", "Email already registered!");
            return "user.register";
        }

        // Default role
        user.setRole("USER");

        userService.saveUser(user);

        model.addAttribute("success", "Registration successful! Please login.");
        return "user.login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "user.login";
    }

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {

        model.addAttribute("products", productService.getAllProducts());

        Map<Long, CartItems> cart =
                (Map<Long, CartItems>) session.getAttribute("cart");

        int cartCount = 0;

        if (cart != null) {
            for (CartItems item : cart.values()) {
                cartCount += item.getQuantity();
            }
        }

        model.addAttribute("cartCount", cartCount);

        return "user.home";
    }

    @PostMapping("/login")
    public String loginUser(String email, String password,
                            HttpSession session, Model model) {

        User user = userService.login(email, password);

        if (user == null) {
            model.addAttribute("error", "Invalid email or password");
            return "user.login";
        }

        session.setAttribute("loggedUser", user);

        if (user.getRole().equals("ADMIN")) {
            return "redirect:/admin/dashboard";
        } else {
            return "redirect:/home";
        }
    }
    //SHOW PRODUCT IMAGE
    @GetMapping("user/product-image")
    @ResponseBody
    public byte[] showProductImage(@RequestParam("id") int productId) {
        Product product = productService.getProductById(productId);
        return product.getImage();
    }
    // ===============================
    // 8️⃣ LOGOUT
    // ===============================
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}
