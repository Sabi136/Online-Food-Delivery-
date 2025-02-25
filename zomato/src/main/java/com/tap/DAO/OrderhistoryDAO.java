package com.tap.DAO;

import java.util.List;

import com.tap.entity.Orderhistory;

public interface OrderhistoryDAO 
{
	void insertOrderHistory(Orderhistory orderhistory);
	List<Orderhistory> getOrdersOnUid(int userId);
	void updateOrderHistory(int ohid, String oh_status);
}
