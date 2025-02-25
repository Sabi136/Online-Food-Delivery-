package com.tap.DaoIMPL;

import java.util.List;

import org.hibernate.Session;

import com.tap.DAO.UserDAO;
import com.tap.Hibernate.hibernateUtil;
import com.tap.entity.User;

public class UserDaoImpl implements UserDAO {

	@Override
	public void addUser(User user) 
	{
		Session session = hibernateUtil.getSession().openSession();
		try
		{
			session.beginTransaction();
			session.save(user);
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
	public User getUserById(int user_id) 
	{
		Session session = hibernateUtil.getSession().openSession();
		User user = null;
		try 
		{    
	        user = session.get(User.class, user_id);
	        if (user == null) 
	        {
	            System.out.println("User with ID " + user_id + " not found.");
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
		return user;
	}

	@Override
	public List<User> getAllUser() 
	{
		Session session = hibernateUtil.getSession().openSession();
		List<User> ulist = null;
		try
		{
			ulist = session.createQuery("from User", User.class).list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
		
		return ulist;
	}

	@Override
	public void updateUser(User user)
	{
		Session session = hibernateUtil.getSession().openSession();
		try
		{
			session.beginTransaction();
			session.update(user);
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
	public void deleteUser(int user_id) 
	{
		Session session = hibernateUtil.getSession().openSession();
		User user = null; 
		try
		{
			session.beginTransaction();
			user = session.get(User.class, user_id);
			
			if(user != null)
			{
				session.delete(user);
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
	public User getUserByEmail(String email) 
	{
		Session session = hibernateUtil.getSession().openSession();
		User user = null;
		try
		{
			session.beginTransaction();
			
			String hql = "from User where email = :email";
			user = session.createQuery(hql,User.class).setParameter("email", email).uniqueResult();
			
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
		
		return user;
	}

}
