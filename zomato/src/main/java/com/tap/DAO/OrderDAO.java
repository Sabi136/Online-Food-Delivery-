package com.tap.DAO;

import com.tap.entity.Orders;

public interface OrderDAO 
{
	void addOrder(Orders orders);
	Orders getOrderById(int order_id);
	void updateOrder(int order_id, String order_status);
}