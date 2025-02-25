package com.tap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.modelClass.Cart;
import com.tap.modelClass.CartItem;

/**
 * Servlet implementation class updateCart
 */
@WebServlet("/updateCart")
public class updateCart extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart != null)
		{
			for( CartItem item : cart.getItems().values())
			{
				String quantityPara = req.getParameter("quantity" + item.getMenu_id());
				
				if(quantityPara != null)
				{
					int updatedQuantity = Integer.parseInt(quantityPara);
					
					cart.updateItem(item.getMenu_id(), updatedQuantity);
				}
			}
		}
		resp.sendRedirect("viewCart.jsp");
	}
}
