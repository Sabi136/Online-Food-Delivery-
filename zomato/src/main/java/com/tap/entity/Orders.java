package com.tap.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name="orders")
public class Orders
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_id")
    private int order_id;
    
    @ManyToOne(cascade = CascadeType.PERSIST)  // Change CascadeType to PERSIST (or MERGE)
    @JoinColumn(name="user_id")
    private User user;
    
    @ManyToOne(cascade = CascadeType.PERSIST)  // Change CascadeType to PERSIST (or MERGE)
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;
    
    @Column(name="total_amount", nullable = false)  // Add 'nullable' to enforce the field must be non-null
    private int total_amount;
    
    @Column(name="order_status", nullable = false)  // Add 'nullable' to enforce the field must be non-null
    private String order_status;
    
    @Column(name="order_date", nullable = false)  // Add 'nullable' to enforce the field must be non-null
    private LocalDateTime order_date;
    
    @Column(name="payment_mode", nullable = false)  // Add 'nullable' to enforce the field must be non-null
    private String payment_mode;

    // Getters and Setters

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public LocalDateTime getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDateTime order_date) {
        this.order_date = order_date;
    }

    public String getPayment_mode() {
        return payment_mode;
    }

    public void setPayment_mode(String payment_mode) {
        this.payment_mode = payment_mode;
    }

    // Constructors

    public Orders(int order_id, User user, Restaurant restaurant, int total_amount, String order_status,
                  LocalDateTime order_date, String payment_mode) {
        super();
        this.order_id = order_id;
        this.user = user;
        this.restaurant = restaurant;
        this.total_amount = total_amount;
        this.order_status = order_status;
        this.order_date = order_date;
        this.payment_mode = payment_mode;
    }

    public Orders(User user, Restaurant restaurant, int total_amount, String order_status, LocalDateTime order_date,
                  String payment_mode) {
        super();
        this.user = user;
        this.restaurant = restaurant;
        this.total_amount = total_amount;
        this.order_status = order_status;
        this.order_date = order_date;
        this.payment_mode = payment_mode;
    }

    public Orders() {
        super();
    }
}
