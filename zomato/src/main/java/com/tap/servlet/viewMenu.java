package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.DAO.MenuDAO;
import com.tap.DAO.RestaurantDAO;
import com.tap.DaoIMPL.MenuDaoIMPL;
import com.tap.DaoIMPL.RestaurantDaoIMPL;
import com.tap.entity.Menu;
import com.tap.entity.Restaurant;

/**
 * Servlet implementation class viewMenu
 */
@WebServlet("/viewMenu")
public class viewMenu extends HttpServlet {

    private HttpSession session;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String restaurant_id_str = req.getParameter("restaurant_id");
        
        // Check for missing or invalid restaurant_id
        if (restaurant_id_str == null || restaurant_id_str.isEmpty()) {
            resp.sendRedirect("errorPage.jsp");
            return;
        }

        try {
            int restaurant_id = Integer.parseInt(restaurant_id_str);
            
            // Fetch restaurant and menu details
            MenuDAO mdaoimpl = new MenuDaoIMPL();
            RestaurantDAO rdaoimpl = new RestaurantDaoIMPL();

            Restaurant restaurantById = rdaoimpl.getRestaurantById(restaurant_id);
            List<Menu> menuByRestaurantId = mdaoimpl.getMenuByRestaurantId(restaurant_id);

            if (restaurantById != null && menuByRestaurantId != null) {
                // Store the data in session
                session = req.getSession();
                session.setAttribute("menuByRestaurantId", menuByRestaurantId);
                session.setAttribute("restaurantById", restaurantById);

                // Redirect to the menu page
                resp.sendRedirect("menu.jsp");
            } else {
                resp.sendRedirect("errorPage.jsp"); // Handle case when no restaurant is found
            }
        } catch (NumberFormatException e) {
            resp.sendRedirect("errorPage.jsp"); // Invalid ID format
        }
    }
}


