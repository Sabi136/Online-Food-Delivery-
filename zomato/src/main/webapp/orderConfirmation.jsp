<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Order Confirmation</h1>
	<div class="order-summary">
	
		<h2>Thank you for your order</h2>
		<p>Your order has been successfully placed. Below are the details of the order:</p>
		<table>
			<tr>
				<th>Order ID</th>
				<td><%= request.getAttribute("order_id") %></td>
			</tr>
			
			<tr>
				<th>Order Date</th>
				<td> <%= request.getAttribute("order_date") %></td>
			</tr>
			
			<tr>
				<th>Total Amount</th>
				<td> <%= request.getAttribute("total_amount") %></td>
			</tr>
			
			<tr>
				<th>Status</th>
				<td> <%= request.getAttribute("order_status") %></td>
			</tr>
		</table>
		
		<a href="orderhistory.jsp" class="btn">View Order History</a> 
        <a href="home.jsp" class="btn">Go to Home</a>
        
	</div>
</body>
</html>