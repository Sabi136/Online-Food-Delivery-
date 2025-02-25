package com.tap.test;

import com.tap.DAO.RestaurantDAO;
import com.tap.DaoIMPL.RestaurantDaoIMPL;
import com.tap.entity.Restaurant;

public class MainApp 
{
	public static void main(String[] args)
	{
		 	Restaurant restaurant = new Restaurant("ABC", "ABC Cuisine", "15mins", "4.5");
	        RestaurantDAO dao = new RestaurantDaoIMPL();
	        dao.addRestaurant(restaurant);
	        System.out.println("Restaurant added!");
	}
}
