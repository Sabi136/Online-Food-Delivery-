package com.tap.modelClass;

import java.util.HashMap;
import java.util.Map;

import com.tap.entity.Restaurant;
import com.tap.entity.User;

public class Cart {
    private Map<Integer, CartItem> items;
    private User user;  // User object associated with the cart
    private Restaurant restaurant;  // Restaurant object associated with the cart

    public Cart() {
        this.items = new HashMap<>();
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    // Adding item to the cart
    public void addItem(CartItem item) {
        if (items.containsKey(item.getMenu_id())) {
            CartItem existingCartItem = items.get(item.getMenu_id());
            existingCartItem.setQuantity(existingCartItem.getQuantity() + item.getQuantity());
        } else {
            items.put(item.getMenu_id(), item);
        }
    }

    // Updating item quantity
    public void updateItem(int menu_id, int quantity) {
        if (items.containsKey(menu_id)) {
            if (quantity <= 0) {
                items.remove(menu_id);
            } else {
                items.get(menu_id).setQuantity(quantity);
            }
        }
    }

    // Removing item from the cart
    public void removeItem(int menu_id) {
        items.remove(menu_id);
    }

    // Calculating total price of items in the cart
    public int getTotalPrice() {
        int total = 0;
        for (CartItem item : items.values()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}