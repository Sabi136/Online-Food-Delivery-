package com.tap.Hibernate;

//import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tap.entity.Menu;
import com.tap.entity.Orderhistory;
import com.tap.entity.Orders;
import com.tap.entity.Restaurant;
import com.tap.entity.User;
import com.tap.entity.orderitem;

public class hibernateUtil 
{
	private static SessionFactory sessionFactory;

	static
	{
		try
		{
			sessionFactory = new Configuration().configure().
								addAnnotatedClass(User.class).
								addAnnotatedClass(Restaurant.class).
								addAnnotatedClass(Orders.class).
								addAnnotatedClass(orderitem.class).
								addAnnotatedClass(Orderhistory.class).
								addAnnotatedClass(Menu.class).
								buildSessionFactory();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getSession()
	{
		return sessionFactory;
	}
	
	public static void shutdown()
	{
		sessionFactory.close();
	}
}
