package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.entity.Menu;
import com.tap.entity.Restaurant;
import com.tap.entity.User;
import com.tap.modelClass.Cart;
import com.tap.modelClass.OrderService;

@WebServlet("/processCheckout")
public class processCheckout extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Step 1: Retrieve session attributes
            Cart cart = (Cart) req.getSession().getAttribute("cart");
            User user = (User) req.getSession().getAttribute("user");
            Restaurant restaurant = (Restaurant) req.getSession().getAttribute("restaurantById"); // Correct cast to List<Restaurant>
            List<Menu> mrlist = (List<Menu>) req.getSession().getAttribute("menuByRestaurantId");

            // Step 2: Check if required session attributes are present
            if (cart == null) {
                System.out.println("Cart is not present in the session.");
            } else {
                System.out.println("Cart is present in the session.");
            }

            if (user == null) {
                System.out.println("User is not present in the session.");
            } else {
                System.out.println("User is present in the session.");
            }

            if (restaurant == null) {  // Changed to allRestaurants (List<Restaurant>)
                System.out.println("Restaurants are not present in the session.");
            } else {
                System.out.println("Restaurants are present in the session.");
            }

            if (mrlist == null) {
                System.out.println("Menu is not present in the session.");
            } else {
                System.out.println("Menu is present in the session.");
            }

            // Proceed to further steps only if all required objects are present
            if (cart == null || user == null || restaurant == null || mrlist == null) {
                resp.sendRedirect("error.jsp");  // redirect to error page if any object is missing
                return;
            }

            // Step 3: Get the required parameters from the form
            String restaurant_id_str = req.getParameter("restaurant_id");
            String user_id_str = req.getParameter("user_id");
            String total_amount_str = req.getParameter("total_amount");
            String payment_mode = req.getParameter("payment_mode");

            if (restaurant_id_str == null || restaurant_id_str.isEmpty()) {
                System.out.println("restaurant_id is missing or empty!");
            }
            if (user_id_str == null || user_id_str.isEmpty()) {
                System.out.println("user_id is missing or empty!");
            }
            if (total_amount_str == null || total_amount_str.isEmpty()) {
                System.out.println("total_amount is missing or empty!");
            }
            if (payment_mode == null || payment_mode.isEmpty()) {
                System.out.println("payment_mode is missing or empty!");
            }

            // Step 5: Parse parameters and calculate total amount
            int restaurant_id = Integer.parseInt(restaurant_id_str);
            int user_id = Integer.parseInt(user_id_str);
            int total_amount = Integer.parseInt(total_amount_str);

            // Step 6: Process order using OrderService
            OrderService orderService = new OrderService();
            orderService.createOrder(restaurant_id, user_id, total_amount, payment_mode);

            // Step 7: Redirect to order success page
            resp.sendRedirect("orderSuccess.jsp");

        } catch (Exception e) {
            // Step 8: Handle errors and log them
            e.printStackTrace();
            resp.sendRedirect("error.jsp");  // redirect to an error page
        }
    }
}