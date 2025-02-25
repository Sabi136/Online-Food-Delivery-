package com.tap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.DAO.RestaurantDAO;
import com.tap.DaoIMPL.RestaurantDaoIMPL;
import com.tap.entity.Restaurant;

/**
 * Servlet implementation class AddRestaurantServlet
 */
@WebServlet("/AddRestaurantServlet")
public class AddRestaurantServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String restaurant_name = req.getParameter("restaurant_name");
		String cuisine_type = req.getParameter("cuisine_type");
		String delivery_time = req.getParameter("delivery_time");
		String ratings = req.getParameter("ratings");

		String restaurant_img = req.getParameter("restaurant_img");
		
		Restaurant r = new Restaurant(restaurant_name, cuisine_type, delivery_time, ratings);
		r.setRestaurant_img(restaurant_img);
		
		RestaurantDAO rdaoimpl = new RestaurantDaoIMPL();
		
		rdaoimpl.addRestaurant(r);
		
		resp.sendRedirect("success.jsp");
		
		System.out.println("Restaurant data with image is added to the Database");
	}
}
