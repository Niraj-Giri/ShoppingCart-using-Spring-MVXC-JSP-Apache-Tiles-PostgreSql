package com.example.shoppingcart.service;

import com.example.shoppingcart.model.Product;
import com.example.shoppingcart.model.User;
import com.example.shoppingcart.repo.ProductRepo;
import com.example.shoppingcart.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    private ProductRepo productRepo;
    public boolean emailExists(String email) {
        return userRepo.findByEmail(email) != null;
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }
    public User login(String email, String password) {
        User user = userRepo.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
  public List<Product> allProduct(){
     return   productRepo.findAll();
  }
}










