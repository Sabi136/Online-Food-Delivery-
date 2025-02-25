package com.tap.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.DAO.MenuDAO;
import com.tap.DaoIMPL.MenuDaoIMPL;
import com.tap.entity.Menu;
import com.tap.modelClass.Cart;
import com.tap.modelClass.CartItem;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get the menu_id and restaurant_id parameters from the request
        String menu_id_str = req.getParameter("menu_id");
        String restaurant_id_str = req.getParameter("restaurant_id");

        // Handle invalid menu_id or restaurant_id gracefully
        if (menu_id_str == null || menu_id_str.isEmpty() || restaurant_id_str == null || restaurant_id_str.isEmpty()) {
            System.out.println("Invalid menu_id or restaurant_id received");
            resp.sendRedirect("errorPage.jsp");  // Redirect to an error page
            return;
        }

        // Get the quantity parameter from the request (default to 1 if not provided)
        String quantity_str = req.getParameter("quantity");
        int quantity = (quantity_str != null && !quantity_str.isEmpty()) ? Integer.parseInt(quantity_str) : 1;

        int menu_id, restaurant_id;
        try {
            menu_id = Integer.parseInt(menu_id_str);
            restaurant_id = Integer.parseInt(restaurant_id_str);
        } catch (NumberFormatException e) {
            System.out.println("Invalid menu_id or restaurant_id format: " + menu_id_str + ", " + restaurant_id_str);
            resp.sendRedirect("errorPage.jsp");  // Redirect to an error page
            return;
        }

        // Create an instance of the MenuDAO
        MenuDAO mdaoimpl = new MenuDaoIMPL();
        Menu menuById = mdaoimpl.getMenuById(menu_id);

        // Check if the menu item exists
        if (menuById != null) {
            // Create a CartItem object with restaurant_id, quantity, and menu details
            CartItem cartItem = new CartItem(menuById, quantity, restaurant_id);  // Pass quantity and restaurant_id here

            // Retrieve the session
            HttpSession session = req.getSession();
            Cart cart = (Cart) session.getAttribute("cart");

            // If no cart exists, create a new cart
            if (cart == null) {
                cart = new Cart();
            }

            // Add the item to the cart
            cart.addItem(cartItem);

            // Set the cart as an attribute in the session
            session.setAttribute("cart", cart);

            // Optionally, set a message to display in the cart page (e.g., success message)
            session.setAttribute("cartMessage", "Item added to the cart!");

        } else {
            // Log and redirect if the menu item is not found
            System.out.println("Menu Item not found for ID: " + menu_id);
            req.setAttribute("errorMessage", "Menu item not found.");
            req.getRequestDispatcher("errorPage.jsp").forward(req, resp);  // Forward to error page with message
            return;
        }

        // Redirect the user to the view cart page
        resp.sendRedirect("viewCart.jsp");
    }
}
