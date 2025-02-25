package com.tap.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderhistory")
public class Orderhistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ohid")
    private int ohid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    @Column(name = "total", nullable = false)
    private int total;

    @Column(name = "oh_status", nullable = false)
    private String oh_status;

    // Getters and Setters
    public int getOhid() {
        return ohid;
    }

    public void setOhid(int ohid) {
        this.ohid = ohid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getOhStatus() {
        return oh_status;
    }

    public void setOhStatus(String ohStatus) {
        this.oh_status = ohStatus;
    }

    // Constructors
    public Orderhistory() {
        super();
    }

    public Orderhistory(User user, Orders order, Timestamp date, int total, String oh_status) {
        super();
        this.user = user;
        this.order = order;
        this.date = date;
        this.total = total;
        this.oh_status = oh_status;
    }

    @Override
    public String toString() {
        return "OrderHistory [ohid=" + ohid + ", user=" + user + ", order=" + order + ", date=" + date + ", total=" + total
                + ", oh_status=" + oh_status + "]";
    }
}
