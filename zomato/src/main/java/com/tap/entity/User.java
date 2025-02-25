package com.tap.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private int user_id;
    
    @Column(name="user_name")
    private String user_name;
    
    @Column(name="email")
    private String email;
    
    @Column(name="password")
    private String password;
    
    @Column(name="address")
    private String address;
    
    @Column(name="role")
    private String role = "customer";  // Default role set to "customer"
    
    @Column(name="createDate")
    private Timestamp createDate; 
    
    @Column(name="last_login_date")
    private Timestamp lastLoginDate;

    // Corrected association with Orders
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orders> orders = new ArrayList<>();

    // Getters and setters

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Timestamp lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    // Constructors

    public User(int user_id, String user_name, String email, String password, String address, String role,
            Timestamp createDate, Timestamp lastLoginDate) {
        super();
        this.user_id = user_id;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.role = role;
        this.createDate = createDate;
        this.lastLoginDate = lastLoginDate;
    }

    public User(String user_name, String email, String password, String address, String role, Timestamp createDate,
            Timestamp lastLoginDate) {
        super();
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.role = role != null ? role : "customer";  // Ensure role is set to "customer" if null
        this.createDate = createDate != null ? createDate : new Timestamp(System.currentTimeMillis());  // Set current time if null
        this.lastLoginDate = lastLoginDate != null ? lastLoginDate : new Timestamp(System.currentTimeMillis());  // Set current time if null
    }

    public User(String user_name, String email, String password, String address, String role) {
        super();
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.role = role != null ? role : "customer";  
        this.createDate = new Timestamp(System.currentTimeMillis());  
        this.lastLoginDate = new Timestamp(System.currentTimeMillis());  
    }

    public User(String user_name, String email, String password, String address) {
        super();
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.role = "customer";  
        this.createDate = new Timestamp(System.currentTimeMillis());  
        this.lastLoginDate = new Timestamp(System.currentTimeMillis());  
    }

    public User() {
        super();
    }    
}
