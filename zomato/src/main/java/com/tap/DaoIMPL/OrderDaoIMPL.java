package com.tap.DaoIMPL;

import org.hibernate.Session;

import com.tap.DAO.OrderDAO;
import com.tap.Hibernate.hibernateUtil;
import com.tap.entity.Orders;

public class OrderDaoIMPL implements OrderDAO {

	@Override
	public void addOrder(Orders orders)
	{
		Session session = hibernateUtil.getSession().openSession();
		try
		{
			session.beginTransaction();
			session.save(orders);
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
	}

	@Override
	public Orders getOrderById(int order_id)
	{
		Session session = hibernateUtil.getSession().openSession();
		Orders order = null;
		try
		{
			order = session.get(Orders.class, order_id);
			
			if(order == null)
			{
				System.out.println("Order with ID "+order_id+" not found.");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return order;
	}

	@Override
	public void updateOrder(int order_id, String order_status) 
	{
		Session session = hibernateUtil.getSession().openSession();
		try
		{
			session.beginTransaction();
			Orders orders = session.get(Orders.class, order_id);
			
			if(orders != null)
			{
				orders.setOrder_status(order_status);
				session.update(orders);
			}
			
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	}

}
