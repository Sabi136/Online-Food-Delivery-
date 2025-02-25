package com.tap.DAO;

import java.util.List;

import com.tap.entity.Restaurant;

public interface RestaurantDAO 
{
	void addRestaurant(Restaurant restaurant);
	Restaurant getRestaurantById(int restaurant_id);
	List<Restaurant> getAllRestaurant();
	void updateRestaurant(Restaurant restaurant);
	void deleteRestaurant(int restaurant_id);
}
