package com.tap.DaoIMPL;

import java.util.List;

import org.hibernate.Session;

import com.tap.DAO.orderitemDAO;
import com.tap.Hibernate.hibernateUtil;
import com.tap.entity.orderitem;

public class orderitemDaoIMPL implements orderitemDAO {

	@Override
	public void insertOrderItem(orderitem oi) 
	{
		Session session = hibernateUtil.getSession().openSession();
		try
		{
			session.beginTransaction();
			session.save(oi);
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
	public List<orderitem> getByOid(int order_id) 
	{
		Session session = hibernateUtil.getSession().openSession();
		List<orderitem> oilist = null;
		try
		{
			session.beginTransaction();
			oilist = session.createQuery("from orderitem where orders.order_id = :order_id",orderitem.class).list();
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
		return oilist;
	}
}
