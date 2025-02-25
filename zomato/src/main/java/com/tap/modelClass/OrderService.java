package com.tap.modelClass;

import java.time.LocalDateTime;

import org.hibernate.Session;

import com.tap.Hibernate.hibernateUtil;
import com.tap.entity.Orders;
import com.tap.entity.Restaurant;
import com.tap.entity.User;

public class OrderService 
{
	public Orders createOrder(int restaurant_id, int user_id, int total_amount, String payment_mode) throws Exception
	{
		try(Session hs = hibernateUtil.getSession().openSession())
		{
			hs.beginTransaction();
			
			Restaurant restaurant = hs.get(Restaurant.class, restaurant_id);
			
			User user = hs.get(User.class, user_id);
			
			if(restaurant == null || user == null)
			{
				System.out.println("Invalid Restaurant or User");
			}
			
			Orders orders = new Orders();
			orders.setRestaurant(restaurant);
			orders.setUser(user);
			orders.setOrder_status("pending");
			orders.setOrder_date(LocalDateTime.now());
			orders.setPayment_mode(payment_mode);
			orders.setTotal_amount(total_amount);
			
			hs.save(orders);
			hs.getTransaction().commit();
			
			return orders;
		}
	}
}
