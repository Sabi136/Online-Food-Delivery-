package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.DAO.RestaurantDAO;
import com.tap.DaoIMPL.RestaurantDaoIMPL;
import com.tap.entity.Restaurant;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet 
{
	private HttpSession session;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session == null || session.getAttribute("user") == null)
		{
			resp.sendRedirect("login.html");
		}
		
		RestaurantDAO rdaoimpl = new RestaurantDaoIMPL();
		
		List<Restaurant> allRestaurant = rdaoimpl.getAllRestaurant();
		
		session.setAttribute("allRestaurant", allRestaurant);
		resp.sendRedirect("home.jsp");
	}
}
