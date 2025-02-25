<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Order Success</title>
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background: #4facfe;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: white;
            text-align: center;
        }
        .success-container {
            max-width: 500px;
            background: white;
            color: #333;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.3);
        }
        h1 {
            color: #28a745;
            font-size: 2rem;
        }
        p {
            font-size: 1.2rem;
            margin-top: 10px;
        }
        .btn {
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #4facfe;
            color: white;
            border: none;
            border-radius: 5px;
            text-transform: uppercase;
            font-weight: bold;
            cursor: pointer;
            text-decoration: none;
        }
        .btn:hover {
            background-color: #00c6ff;
        }
    </style>
</head>
<body>
    <div class="success-container">
        <h1>Order Successful!</h1>
        <p>Thank you for your purchase. Your order has been confirmed.</p>
        <a href="home.jsp" class="btn">Return to Home</a>
    </div>
</body>
</html>
