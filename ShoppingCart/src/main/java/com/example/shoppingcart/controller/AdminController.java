package com.example.shoppingcart.controller;

import com.example.shoppingcart.model.Orders;
import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.model.User;
import com.example.shoppingcart.repo.OrdersRepo;
import com.example.shoppingcart.service.AdminService;
import com.example.shoppingcart.service.ProductService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrdersRepo ordersRepo;

    // ===============================
    // 1️⃣ ADMIN DASHBOARD – ALL PRODUCTS
    // ===============================
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "admin.dashboard";
    }


    //SHOW PRODUCT IMAGE
    @GetMapping("/product-image")
    @ResponseBody
    public byte[] showProductImage(@RequestParam("id") int productId) {
        Product product = productService.getProductById(productId);
        return product.getImage();
    }

    // ===============================
    // 2️⃣ SHOW ADD PRODUCT PAGE
    // ===============================
    @GetMapping("/add-product")
    public String showAddProductPage() {

        return "admin.addProduct";
    }

    // ===============================
    // 3️⃣ SAVE PRODUCT (CREATE)
    // ===============================
    @PostMapping("/save-product")
    public String saveProduct(
            @RequestParam("productName") String productName,
            @RequestParam("productDescription") String productDescription,
            @RequestParam("productPrice") double productPrice,
            @RequestParam("image") MultipartFile imageFile
    ) throws IOException {

        Product product = new Product();
        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setProductPrice(productPrice);
        product.setImage(imageFile.getBytes());

        productService.addProduct(product);

        return "redirect:/admin/dashboard";
    }

    // ===============================
    // 4️⃣ PRODUCT DETAILS PAGE
    // ===============================
    @GetMapping("/product")
    public String productDetails(@RequestParam("id") int productId, Model model) {
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "admin.productDetails";
    }

    // ===============================
    // 5️⃣ SHOW EDIT PRODUCT PAGE
    // ===============================
    @GetMapping("/edit-product")
    public String showEditProduct(@RequestParam("id") int productId, Model model) {
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "admin/editProduct";
    }

    // ===============================
    // 6️⃣ UPDATE PRODUCT
    // ===============================
    @PostMapping("/update-product")
    public String updateProduct(
            @RequestParam("productId") int productId,
            @RequestParam("productName") String productName,
            @RequestParam("productDescription") String productDescription,
            @RequestParam("productPrice") double productPrice,
            @RequestParam(value = "image", required = false) MultipartFile imageFile
    ) throws IOException {

        Product product = productService.getProductById(productId);

        product.setProductName(productName);
        product.setProductDescription(productDescription);
        product.setProductPrice(productPrice);

        // Update image only if new image is uploaded
        if (imageFile != null && !imageFile.isEmpty()) {
            product.setImage(imageFile.getBytes());
        }

        productService.updateProduct(product);

        return "redirect:/admin/dashboard";
    }

    // ===============================
    // 7️⃣ DELETE PRODUCT
    // ===============================
    @GetMapping("/delete-product")
    public String deleteProduct(@RequestParam("id") int productId) {
        productService.deleteProduct(productId);
        return "redirect:/admin/dashboard";
    }
  // get all orders

    @GetMapping("/orders")
    public String showAllOrders(HttpSession session, Model model) {

        User admin = (User) session.getAttribute("loggedUser");
        if (admin == null || !"ADMIN".equals(admin.getRole())) {
            return "redirect:/login";
        }

        List<Orders> orders =ordersRepo.findAll();
        model.addAttribute("orders", orders);

        return "admin.orders";
    }


}
