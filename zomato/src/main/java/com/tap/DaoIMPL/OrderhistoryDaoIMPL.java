package com.tap.DaoIMPL;

import java.util.List;

import org.hibernate.Session;

import com.tap.DAO.OrderhistoryDAO;
import com.tap.Hibernate.hibernateUtil;
import com.tap.entity.Orderhistory;

public class OrderhistoryDaoIMPL implements OrderhistoryDAO {

	@Override
	public void insertOrderHistory(Orderhistory orderhistory) 
	{
		Session session = hibernateUtil.getSession().openSession();
		try
		{
			session.beginTransaction();
			session.save(orderhistory);
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
	public List<Orderhistory> getOrdersOnUid(int userId) 
	{
		Session session = hibernateUtil.getSession().openSession();
		List<Orderhistory> ohlist = null;
		try 
		{
			ohlist = session.createQuery("from Orderhistory WHERE user.user_id = :userId", Orderhistory.class).list();                       
		} 
		catch (Exception e) 
		{
			e.printStackTrace(); 
		} 
		finally 
		{
			session.close(); 
		}
		return ohlist;
	}

	@Override
	public void updateOrderHistory(int ohid, String oh_status)
	{
		Session session = hibernateUtil.getSession().openSession();
		try
		{
			session.beginTransaction();
			Orderhistory orderhistory = session.get(Orderhistory.class, ohid);
			if (orderhistory != null) 
			{
				
				orderhistory.setOhStatus(oh_status);
				session.update(orderhistory);
				session.getTransaction().commit();
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
	}
}