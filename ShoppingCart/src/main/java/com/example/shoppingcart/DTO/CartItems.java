package com.example.shoppingcart.DTO;

public class CartItems {
    private int productId;
    private String productName;
    private double productPrice;
    private byte[] image;
    private int stock;

    public CartItems() {}

    public CartItems( int productId, String name, double price, byte[] image) {
        this.productId = productId;
        this.productName = name;
        this.productPrice= price;
        this.image = image;
        this.stock = 1;
    }

    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getProductPrice() { return productPrice; }
    public byte[] getImage() { return image; }
    public int getQuantity() { return stock; }

    public void setQuantity(int quantity) { this.stock = quantity; }
}
