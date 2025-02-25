package com.tap.modelClass;

import com.tap.entity.Menu;

public class CartItem {
    private int menu_id;
    private int restaurant_id;  // Already present
    private String item_name;
    private int price;
    private int quantity;
    private String imageUrl;

    // Constructor to include restaurant_id
    public CartItem(Menu menu, int quantity, int restaurant_id) {
        this.menu_id = menu.getMenu_id();
        this.item_name = menu.getItem_name();
        this.price = menu.getPrice();
        this.quantity = quantity;
        this.imageUrl = menu.getMenu_img();
        this.restaurant_id = restaurant_id; // Initialize restaurant_id
    }

    // Constructor with restaurant_id, menu_id, item_name, price, and quantity
    public CartItem(int menu_id, int restaurant_id, String item_name, int price, int quantity) {
        this.menu_id = menu_id;
        this.restaurant_id = restaurant_id;
        this.item_name = item_name;
        this.price = price;
        this.quantity = quantity;
    }

    // Constructor without restaurant_id (useful for the original version of CartItem)
    public CartItem(int menu_id, String item_name, int price, int quantity, String imageUrl) {
        this.menu_id = menu_id;
        this.item_name = item_name;
        this.price = price;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
    }

    // Getters and setters for all fields
    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
