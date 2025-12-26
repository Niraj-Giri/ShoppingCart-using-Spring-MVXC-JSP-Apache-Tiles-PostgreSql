package com.example.shoppingcart.service;

import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    // ===============================
    // CREATE
    // ===============================

    public void addProduct(Product product) {
        productRepo.save(product);
        System.out.println("saved product");
    }

    // ===============================
    // READ – ALL PRODUCTS
    // ===============================

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    // ===============================
    // READ – SINGLE PRODUCT
    // ===============================

    public Product getProductById(int productId) {
        return productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // ===============================
    // UPDATE
    // ===============================

    public void updateProduct(Product product) {
        productRepo.save(product);
    }

    // ===============================
    // DELETE
    // ===============================

    public void deleteProduct(int productId) {
        productRepo.deleteById(productId);
    }
}
