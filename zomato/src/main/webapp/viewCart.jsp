<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.tap.modelClass.Cart, com.tap.modelClass.CartItem, com.tap.entity.Restaurant" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cart Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 40px auto;
            background-color: white;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        h2 {
            text-align: center;
            color: #333;
            font-size: 24px;
        }
        .restaurant-info {
            margin: 20px 0;
            padding: 15px;
            background-color: #f2f2f2;
            border-radius: 8px;
        }
        .restaurant-info p {
            margin: 5px 0;
            font-size: 16px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
            color: #333;
            font-size: 16px;
        }
        td {
            color: #555;
            font-size: 14px;
        }
        td img {
            width: 60px;
            height: 60px;
            object-fit: cover;
            border-radius: 5px;
        }
        input[type="number"] {
            width: 60px;
            padding: 5px;
            text-align: center;
            font-size: 14px;
        }
        .total {
            text-align: right;
            font-weight: bold;
            font-size: 18px;
            margin-top: 20px;
            padding: 10px;
            background-color: #f2f2f2;
            border-radius: 8px;
        }
        .empty-cart {
            text-align: center;
            font-size: 18px;
            color: #888;
            margin-top: 30px;
        }
        .update-btn {
            background-color: #4CAF50;
            color: white;
            padding: 5px 10px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            font-size: 14px;
        }
        .update-btn:hover {
            background-color: #45a049;
        }
        
        .add-more-btn {
            display: inline-block;
            background-color: #2196F3;
            color: white;
            padding: 5px 10px;
            text-decoration: none;
            border-radius: 5px;
            font-size: 14px;
            margin-left: 10px;
        }
        .add-more-btn:hover {
            background-color: #1E88E5;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Your Cart</h2>
        <%
            // Retrieve the cart and restaurant details from the session
            Cart cart = (Cart) session.getAttribute("cart");
            Restaurant restaurant = (Restaurant) session.getAttribute("restaurantById");

            // Safely display restaurant details if available
            if (restaurant != null) {
        %>
        <div class="restaurant-info">
            <h3>Restaurant Details</h3>
            <p><strong>Name:</strong> <%= restaurant.getRestaurant_name() %></p>
            <p><strong>Cuisine:</strong> <%= restaurant.getCuisine_type() != null ? restaurant.getCuisine_type() : "Not Available" %></p>
            <p><strong>Restaurant ID:</strong> <%= restaurant.getRestaurant_id() %></p>
        </div>
        <% } else { %>
        <div class="restaurant-info">
            <p><strong>Error:</strong> Restaurant details not available.</p>
        </div>
        <% } %>

        <%
            // Check if the cart is not empty
            if (cart != null && !cart.getItems().isEmpty()) {
        %>
        <form action="updateCart" method="post">
            <table>
                <thead>
                    <tr>
                        <th>Image</th>
                        <th>Item Name</th>
                        <th>Menu ID</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        // Loop through each cart item and display it
                        for (CartItem item : cart.getItems().values()) {
                    %>
                    <tr>
                        <td>
                            <% if (item.getImageUrl() != null) { %>
                                <img src="<%= item.getImageUrl() %>" alt="<%= item.getItem_name() %>">
                            <% } else { %>
                                <p>No Image</p>
                            <% } %>
                        </td>
                        <td><%= item.getItem_name() %></td>
                        <td><%= item.getMenu_id() %></td>
                        <td>
                            <input type="number" name="quantity<%= item.getMenu_id() %>" value="<%= item.getQuantity() %>" min="1">
                        </td>
                        <td>₹<%= item.getPrice() %></td>
                        <td>₹<%= item.getPrice() * item.getQuantity() %></td>
                    </tr>
                    <% 
                        } 
                    %>
                </tbody>
            </table>
            <div class="total">
                Total: ₹<%= cart.getTotalPrice() %>
            </div>
            <div style="text-align: center; margin-top: 20px;">
                <button type="submit" class="update-btn">Update Cart</button>
                <a href="home.jsp" class="add-more-btn">Add More Items</a>
                <a href="checkout.jsp" class="add-more-btn">Go to Checkout</a>
            </div>
        </form>
        <% } else { %>
            <p class="empty-cart">Your Cart is empty.</p>
        <% } %>
    </div>
</body>
</html>
