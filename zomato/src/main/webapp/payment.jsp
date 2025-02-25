<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Payment Page</title>
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(to bottom right, #4facfe, #00f2fe);
            margin: 0;
            padding: 0;
            color: #333;
        }
        .payment-container {
            max-width: 700px;
            margin: 50px auto;
            padding: 30px;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);
            text-align: center;
        }
        .payment-container h1 {
            margin-bottom: 20px;
            color: #222;
        }
        .payment-container p {
            margin-bottom: 40px;
            color: #555;
        }
        .form-group {
            margin-bottom: 20px;
            text-align: left;
        }
        label {
            font-weight: bold;
            margin-bottom: 8px;
            display: block;
            color: #555;
        }
        input[type="text"], input[type="number"], input[type="email"], input[type="password"], select {
            width: 100%;
            padding: 12px;
            margin-top: 5px;
            border: 1px solid #ddd;
            border-radius: 6px;
            font-size: 16px;
            box-sizing: border-box;
        }
        input[type="text"]:focus, input[type="number"]:focus, input[type="password"]:focus, select:focus {
            outline: none;
            border-color: #4facfe;
            box-shadow: 0 0 5px rgba(79, 172, 254, 0.8);
        }
        .btn {
            display: inline-block;
            width: 100%;
            padding: 15px;
            margin-top: 20px;
            background: #4facfe;
            color: #fff;
            font-size: 18px;
            font-weight: bold;
            text-transform: uppercase;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            transition: background 0.3s ease;
        }
        .btn:hover {
            background: #00c6ff;
        }
        .secure-badge {
            display: flex;
            align-items: center;
            justify-content: center;
            margin-top: 20px;
            color: #666;
            font-size: 14px;
        }
        .secure-badge img {
            margin-right: 10px;
            width: 20px;
            height: 20px;
        }
        .footer-note {
            margin-top: 20px;
            font-size: 12px;
            color: #999;
        }
    </style>
</head>
<body>
    <div class="payment-container">
        <h1>Secure Payment</h1>
        <p>Complete your payment to confirm the order</p>
        <form action="orderSuccess.jsp" method="POST">
            <div class="form-group">
                <label for="cardName">Name on Card</label>
                <input type="text" id="cardName" name="cardName" placeholder="John Doe" required>
            </div>
            <div class="form-group">
                <label for="cardNumber">Card Number</label>
                <input type="number" id="cardNumber" name="cardNumber" placeholder="1234 5678 9012 3456" required>
            </div>
            <div class="form-group">
                <label for="expiryDate">Expiry Date</label>
                <input type="text" id="expiryDate" name="expiryDate" placeholder="MM/YY" required>
            </div>
            <div class="form-group">
                <label for="cvv">CVV</label>
                <input type="password" id="cvv" name="cvv" maxlength="3" placeholder="123" required>
            </div>
            <div class="form-group">
                <label for="paymentMethod">Payment Method</label>
                <select id="paymentMethod" name="paymentMethod">
                    <option value="credit">Credit Card</option>
                    <option value="debit">Debit Card</option>
                    <option value="upi">UPI</option>
                    <option value="netbanking">Net Banking</option>
                </select>
            </div>
            <button type="submit" class="btn">Make Payment</button>
        </form>
        <div class="secure-badge">
            <img src="https://img.icons8.com/material-outlined/24/000000/lock--v1.png" alt="Secure">
            <span>100% Secure Payment</span>
        </div>
        <div class="footer-note">
            Your details are encrypted and securely processed.
        </div>
    </div>
</body>
</html>
