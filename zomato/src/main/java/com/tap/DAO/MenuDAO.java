package com.tap.DAO;

import java.util.List;

import com.tap.entity.Menu;

public interface MenuDAO 
{
	void addMenu(Menu menu);
	Menu getMenuById(int menu_id);
	List<Menu> getAllMenu();
	void updateMenu(Menu menu);
	void deleteMenu(int menu_id);
	List<Menu> getMenuByRestaurantId(int restaurant_id);
}
