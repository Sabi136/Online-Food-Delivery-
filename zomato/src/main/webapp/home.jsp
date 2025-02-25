<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.entity.User, com.tap.entity.Restaurant, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #333;
            color: #fff;
            padding: 10px 20px;
        }

        .navbar .app-name {
            font-size: 24px;
            font-weight: bold;
        }

        .navbar .user-name {
            font-size: 18px;
        }

        .navbar .nav-links a {
            color: #fff;
            text-decoration: none;
            margin: 0 10px;
            font-size: 16px;
        }

        .navbar .nav-links a:hover {
            text-decoration: underline;
        }

        .content {
            padding: 20px;
        }

        .content h2 {
            text-align: center;
            font-size: 28px;
            margin-bottom: 20px;
        }

        .restaurant-cards {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
        }

        .restaurant-card {
            background: linear-gradient(to top, #ff7e5f, #feb47b);
            color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: transform 0.2s ease-in-out;
            padding: 15px;
            width: 300px;
            text-align: center;
        }

        .restaurant-card:hover {
            transform: scale(1.05);
            box-shadow: 0 6px 8px rgba(0, 0, 0, 0.15);
        }

        .restaurant-card img {
            width: 100%;
            height: 150px;
            object-fit: cover;
            border-radius: 8px;
            margin-bottom: 10px;
        }

        .restaurant-card h3 {
            font-size: 20px;
            margin-bottom: 10px;
            font-weight: bold;
        }

        .restaurant-card p {
            font-size: 16px;
            margin-bottom: 5px;
        }

        .restaurant-card .rating {
            font-size: 18px;
            color: #FFD700;
            font-weight: bold;
        }

        .restaurant-card .view-menu-btn {
            display: inline-block;
            margin-top: 10px;
            padding: 6px 12px; /* Reduced padding */
            font-size: 14px; /* Smaller font size */
            background-color: #333;
            color: #fff;
            text-decoration: none;
            border-radius: 20px; /* Rounded edges for a stylish look */
            border: 2px solid #444; /* Border for added style */
            cursor: pointer;
            transition: all 0.3s ease-in-out; /* Smooth transition for hover effect */
        }

        .restaurant-card .view-menu-btn:hover {
            background-color: #444; /* Slightly lighter background on hover */
            color: #FFD700; /* Stylish golden color on hover */
            border-color: #FFD700; /* Golden border on hover */
            transform: translateY(-2px); /* Slight lift effect */
        }
    </style>
</head>
<body>
    <!-- Navigation Bar -->
    <div class="navbar">
        <div class="app-name">FoodieApp</div>
        <div class="user-name">
            <% User user = (User) session.getAttribute("user");
            if (user != null) {
                out.print("Heyy, " + user.getUser_name());
            } else {
                out.print("Heyy, Guest");
            } %>
        </div>
        <div class="nav-links">
            <a href="viewCart.jsp">Cart</a>
            <a href="orderHistory.html">Order History</a>
            <a href="profile.html">Profile</a>
        </div>
    </div>

    <!-- Page Content -->
    <div class="content">
        <h2>All Restaurants</h2>
        <%
            List<Restaurant> allRestaurant = (List<Restaurant>) session.getAttribute("allRestaurant");
            if (allRestaurant != null && !allRestaurant.isEmpty()) {
        %>
        <!-- Restaurant Cards -->
        <div class="restaurant-cards">
            <% for (Restaurant restaurant : allRestaurant) { %>
                <div class="restaurant-card">
                    <img src="<%= restaurant.getRestaurant_img() %>" alt="<%= restaurant.getRestaurant_name() %>">
                    <h3><%= restaurant.getRestaurant_name() %></h3>
                    <p><strong>Cuisine:</strong> <%= restaurant.getCuisine_type() %></p>
                    <p class="rating"><strong>Rating:</strong> <%= restaurant.getRatings() %></p>
                    <a href="viewMenu?restaurant_id=<%= restaurant.getRestaurant_id() %>" class="view-menu-btn">View Menu</a>
                </div>
            <% } %>
        </div>
        <% 
            } else {
        %>
        <p>No Restaurants found.</p>
        <% } %>
    </div>
</body>
</html>