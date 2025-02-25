<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tap.entity.Menu, java.util.List, com.tap.entity.Restaurant" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu Page</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }

    .header {
        background-color: #333;
        color: #fff;
        text-align: center;
        padding: 15px 0;
        font-size: 1.8em;
        margin-bottom: 20px;
    }

    .container {
        width: 80%;
        max-width: 1200px;
        margin: 0 auto;
        padding-top: 30px;
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
        overflow: hidden;
        padding-bottom: 20px;
    }

    .menu-items {
        display: flex;
        flex-direction: column;
        gap: 15px;
        padding: 15px;
    }

    .menu-item {
        background-color: #fff;
        border-radius: 8px;
        padding: 15px;
        display: flex;
        align-items: center;
        gap: 20px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        transition: transform 0.3s, box-shadow 0.3s;
    }

    .menu-item:hover {
        transform: translateY(-5px);
        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
    }

    .menu-item img {
        width: 100px;
        height: 100px;
        object-fit: cover;
        border-radius: 8px;
        transition: transform 0.3s;
    }

    .menu-item:hover img {
        transform: scale(1.1);
    }

    .menu-item-details {
        flex-grow: 1;
        text-align: left;
    }

    .item-name {
        font-size: 1.2em;
        font-weight: bold;
        margin: 0;
        color: #333;
    }

    .item-description {
        font-size: 0.9em;
        color: #666;
        margin: 5px 0;
    }

    .item-price {
        font-size: 1.2em;
        font-weight: bold;
        color: #e74c3c;
        margin-top: 8px;
    }

    .add-to-cart {
        background-color: transparent;
        border: none;
        cursor: pointer;
        transition: transform 0.3s;
        font-size: 1.5em; /* Adjust the icon size */
    }

    .add-to-cart:hover {
        transform: scale(1.1);
    }

    .no-items {
        text-align: center;
        font-size: 1em;
        color: #555;
        margin-top: 50px;
    }
</style>
</head>
<body>
    <div class="header">
        <%
            Restaurant restaurant = (Restaurant) session.getAttribute("restaurantById");
            if (restaurant != null) {
        %>
            <h1>Menu Details of <%= restaurant.getRestaurant_name() %></h1>
            <p>Restaurant ID: <%= restaurant.getRestaurant_id() %></p>
        <% } else { %>
            <h1>Menu Details</h1>
        <% } %>
    </div>

    <div class="container">
        <% 
            List<Menu> mrlist = (List<Menu>)session.getAttribute("menuByRestaurantId");
            if (mrlist != null && !mrlist.isEmpty()) {
        %>
        <div class="menu-items">
            <%  
                for (Menu m : mrlist) {
            %>
                <div class="menu-item">
                    <img src="<%= m.getMenu_img() %>" alt="<%= m.getItem_name() %>">
                    <div class="menu-item-details">
                        <h3 class="item-name"><%= m.getItem_name() %></h3>
                        <p class="item-description"><%= m.getDescription() %></p>
                        <p class="item-price">₹<%= m.getPrice() %></p>
                    </div>
                    
                    <form action="AddToCartServlet" method="post">
                        <input type="hidden" name="menu_id" value="<%= m.getMenu_id() %>">
                        <input type="hidden" name="restaurant_id" value="<%= restaurant.getRestaurant_id() %>">
                        <input type="hidden" name="restaurant_name" value="<%= restaurant.getRestaurant_name() %>">
                        <button type="submit" class="add-to-cart">
                            <i class="fas fa-shopping-cart"></i> <!-- Font Awesome Cart Icon -->
                        </button>
                    </form>
                </div>
            <% } %>
        </div>
        <% } else { %>
        <p class="no-items">No Menu Items available for this restaurant.</p>
        <% } %>
    </div>
</body>
</html>