package com.tap.DaoIMPL;

import java.util.List;

import org.hibernate.Session;

import com.tap.DAO.RestaurantDAO;
import com.tap.Hibernate.hibernateUtil;
import com.tap.entity.Restaurant;

public class RestaurantDaoIMPL implements RestaurantDAO {

	@Override
	public void addRestaurant(Restaurant restaurant) 
	{
		Session session = hibernateUtil.getSession().openSession();
		try
		{
			session.beginTransaction();
			session.save(restaurant);
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
	public Restaurant getRestaurantById(int restaurant_id) 
	{
		Session session = hibernateUtil.getSession().openSession();
		Restaurant restaurant = null;
		
		try
		{
			restaurant = session.get(Restaurant.class, restaurant_id);
			
			if(restaurant == null)
			{
				System.out.println("Restaurant with ID "+restaurant_id+" not found.");
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
		return restaurant;
	}

	@Override
	public List<Restaurant> getAllRestaurant() 
	{
		Session session = hibernateUtil.getSession().openSession();
		List<Restaurant> rlist = null;
		try
		{
			rlist = session.createQuery("from Restaurant",Restaurant.class).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return rlist;
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) 
	{
		Session session = hibernateUtil.getSession().openSession();
		try
		{
			session.beginTransaction();
			session.update(restaurant);
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
	public void deleteRestaurant(int restaurant_id)
	{
		Session session = hibernateUtil.getSession().openSession();
		Restaurant restaurant = null;
		try
		{
			session.beginTransaction();
			restaurant = session.get(Restaurant.class, restaurant_id);
			
			if(restaurant != null)
			{ 
				session.delete(restaurant);
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