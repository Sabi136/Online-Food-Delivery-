<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.modelClass.Cart, com.tap.modelClass.CartItem, com.tap.entity.User, com.tap.entity.Restaurant, com.tap.entity.Menu" %>    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Checkout Page</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f3f4f7;
        margin: 0;
        padding: 0;
        color: #333;
    }

    .container {
        width: 80%;
        margin: 30px auto;
        background-color: #fff;
        padding: 30px;
        border-radius: 8px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        border-top: 5px solid #3498db;
    }

    h2 {
        text-align: center;
        color: #3498db;
        font-size: 32px;
        margin-bottom: 20px;
    }

    h3 {
        color: #2c3e50;
        font-size: 20px;
        margin-bottom: 15px;
    }

    label {
        font-weight: bold;
        font-size: 16px;
    }

    input[type="text"], input[type="email"], textarea, select {
        width: 100%;
        padding: 12px;
        margin: 8px 0;
        border: 1px solid #ccc;
        border-radius: 6px;
        font-size: 14px;
        box-sizing: border-box;
        background-color: #f9f9f9;
    }

    textarea {
        resize: vertical;
        min-height: 100px;
    }

    button {
        background-color: #e74c3c;
        color: white;
        padding: 12px;
        font-size: 18px;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        width: 100%;
        margin-top: 20px;
        transition: background-color 0.3s ease;
    }

    button:hover {
        background-color: #c0392b;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    th, td {
        padding: 12px;
        text-align: left;
        border: 1px solid #ddd;
    }

    th {
        background-color: #3498db;
        color: white;
    }

    td {
        background-color: #f9f9f9;
        color: #555;
    }

    tr:nth-child(even) td {
        background-color: #f2f3f5;
    }

    .total-amount {
        font-size: 22px;
        font-weight: bold;
        color: #e74c3c;
        margin-top: 15px;
    }

    .payment-section {
        margin-top: 20px;
    }

    select {
        width: 100%;
        padding: 12px;
        margin: 8px 0;
        border-radius: 6px;
        background-color: #f9f9f9;
    }

    .empty-cart-message {
        color: #e74c3c;
        font-size: 18px;
        text-align: center;
    }

    .back-to-home {
        text-align: center;
        margin-top: 20px;
    }

    .back-to-home a {
        color: #3498db;
        text-decoration: none;
        font-size: 16px;
    }

    .back-to-home a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
    <div class="container">
        <h2>Checkout</h2>
        
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            User user = (User) session.getAttribute("user");
            Restaurant restaurant = (Restaurant) session.getAttribute("restaurantById");
            Menu menu = (Menu) session.getAttribute("menu");

            // Redirect if user or cart is null, or cart is empty
            if (user == null) {
                response.sendRedirect("login.jsp");
                return;
            }
            if (cart == null || cart.getItems().isEmpty()) {
                out.println("<p class='empty-cart-message'>Your cart is empty. <a href='menu.jsp'>Add items to your cart</a> before proceeding to checkout.</p>");
                return;
            }
        %>
        
        <form action="processCheckout" method="POST">
            <h3>User Details</h3>
            <label for="user_name">Name:</label>
            <input type="text" id="user_name" name="user_name" value="<%= user.getUser_name() %>" readonly="readonly">
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="<%= user.getEmail() %>" readonly="readonly">
            
            <label for="address">Address:</label>
            <textarea id="address" name="address" rows="4" cols="50" required><%= user.getAddress() != null ? user.getAddress() : "" %></textarea>
            
            <h3>Restaurant Details</h3>
            <%
                if (restaurant != null) {
            %>
                <label>Restaurant ID:</label>
                <p><%= restaurant.getRestaurant_id() %></p>
                <label>Restaurant Name:</label>
                <p><%= restaurant.getRestaurant_name() != null ? restaurant.getRestaurant_name() : "N/A" %></p>
            <%
                } else {
            %>
                <p>No restaurant information available.</p>
            <%
                }
            %>

            <h3>Menu Details</h3>
            <%
                if (menu != null) {
            %>
                <label>Menu ID:</label>
                <p><%= menu.getMenu_id() %></p>
                <label>Menu Item Name:</label>
                <p><%= menu.getItem_name() != null ? menu.getItem_name() : "N/A" %></p>
            <%
                } else {
            %>
                <p>No menu information available.</p>
            <%
                }
            %>
            
            <h3>Order Summary</h3>
            <table>
                <thead>
                    <tr>
                        <th>Item</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int totalAmount = 0;
                        for (CartItem item : cart.getItems().values()) {
                            totalAmount += item.getPrice() * item.getQuantity();
                    %>
                    <tr>
                        <td><%= item.getItem_name() %></td>
                        <td><%= item.getQuantity() %></td>
                        <td>₹<%= item.getPrice() %></td>
                        <td>₹<%= item.getPrice() * item.getQuantity() %></td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
            
            <div class="total-amount">
                Total Amount: ₹<%= totalAmount %>
            </div>
            
            <div class="payment-section">
                <h3>Payment Mode</h3>
                <select name="payment_mode" required>
                    <option value="" disabled selected>Select Payment Mode</option>
                    <option value="Cash on Delivery">Cash on Delivery</option>
                    <option value="Credit Card">Credit Card</option>
                    <option value="Debit Card">Debit Card</option>
                    <option value="UPI">UPI</option>
                </select><br>
            </div>

            <!-- Hidden fields to collect user_id, restaurant_id, and menu_id -->
            <% if (restaurant != null) { %>
                <input type="hidden" name="restaurant_id" value="<%= restaurant.getRestaurant_id() %>">
            <% } %>
            <% if (menu != null) { %>
                <input type="hidden" name="menu_id" value="<%= menu.getMenu_id() %>">
            <% } %>
            <input type="hidden" name="user_id" value="<%= user.getUser_id() %>">
            <input type="hidden" name="total_amount" value="<%= totalAmount %>">
            
            <button type="submit">Place Order</button>
        </form>

        <div class="back-to-home">
            <a href="menu.jsp">Back to Menu</a>
        </div>
    </div>
</body>
</html>