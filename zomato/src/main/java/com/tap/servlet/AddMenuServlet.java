package com.tap.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.DaoIMPL.MenuDaoIMPL;
import com.tap.DaoIMPL.RestaurantDaoIMPL;
import com.tap.entity.Menu;
import com.tap.entity.Restaurant;

/**
 * Servlet implementation class AddMenuServlet
 */
@WebServlet("/AddMenuServlet")
public class AddMenuServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int restaurantId = Integer.parseInt(req.getParameter("restaurant_id"));
	    String itemName = req.getParameter("item_name");
	    String description = req.getParameter("description");
	    String menuImg = req.getParameter("menu_img");
	    int price = Integer.parseInt(req.getParameter("price")); 
	    
	    RestaurantDaoIMPL rdaoimpl = new RestaurantDaoIMPL();
	    
	    MenuDaoIMPL mdaoimpl = new MenuDaoIMPL();
	    
	    Restaurant restaurant = rdaoimpl.getRestaurantById(restaurantId);
	    
	    if (restaurant == null) 
	    {
            req.setAttribute("error", "Invalid Restaurant ID. Please enter a valid restaurant ID.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("addMenu.html");
            dispatcher.forward(req, resp);
	    }
	    else
	    {
	    	Menu menu = new Menu();
	    	menu.setRestaurant(restaurant); // Set the associated restaurant
            menu.setItem_name(itemName);
            menu.setDescription(description);
            menu.setMenu_img(menuImg); // URL of the image
            menu.setPrice(price);
            
            mdaoimpl.addMenu(menu);
            
            resp.sendRedirect("success.jsp");
	    }
	}
}
