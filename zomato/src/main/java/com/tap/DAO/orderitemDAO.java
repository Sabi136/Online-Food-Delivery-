package com.tap.DAO;

import java.util.List;

import com.tap.entity.orderitem;

public interface orderitemDAO 
{
	void insertOrderItem(orderitem oi);
	List<orderitem> getByOid(int order_id);
}
