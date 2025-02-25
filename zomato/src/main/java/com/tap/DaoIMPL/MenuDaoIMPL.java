package com.tap.DaoIMPL;

import java.util.List;

import org.hibernate.Session;

import com.tap.DAO.MenuDAO;
import com.tap.Hibernate.hibernateUtil;
import com.tap.entity.Menu;

public class MenuDaoIMPL implements MenuDAO {

	@Override
	public void addMenu(Menu menu) 
	{
		Session session = hibernateUtil.getSession().openSession();
		try
		{
			session.beginTransaction();
			session.save(menu);
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
	public Menu getMenuById(int menu_id) 
	{
		Session session = hibernateUtil.getSession().openSession();
		Menu menu = null;
		try
		{
			menu = session.get(Menu.class, menu_id);

			if(menu == null)
			{
				System.out.println("Menu with ID "+menu_id+" not found.");
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

		return menu;
	}

	@Override
	public List<Menu> getAllMenu()
	{
		Session session = hibernateUtil.getSession().openSession();
		List<Menu> mlist = null;
		try
		{
			mlist = session.createQuery("from Menu", Menu.class).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}

		return mlist;
	}

	@Override
	public void updateMenu(Menu menu) 
	{
		Session session = hibernateUtil.getSession().openSession();
		try
		{
			session.beginTransaction();
			session.update(menu);
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
	public void deleteMenu(int menu_id)
	{
		Session session = hibernateUtil.getSession().openSession();
		Menu menu = null;
		try
		{
			session.beginTransaction();
			menu = session.get(Menu.class, menu_id);

			if(menu != null)
			{
				session.delete(menu);
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

	@Override
	public List<Menu> getMenuByRestaurantId(int restaurant_id) {
		Session session = hibernateUtil.getSession().openSession();
		List<Menu> mrlist = null;
		try {
			String hql = "from Menu m where m.restaurant.restaurant_id = :restaurant_id";
			mrlist = session.createQuery(hql, Menu.class)
					.setParameter("restaurant_id", restaurant_id)
					.getResultList();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
		return mrlist;
	}
}