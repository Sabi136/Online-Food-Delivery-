package com.tap.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.DAO.UserDAO;
import com.tap.DaoIMPL.UserDaoImpl;
import com.tap.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	private HttpSession session;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UserDAO udaoimpl = new UserDaoImpl();
		
		User user = udaoimpl.getUserByEmail(email);
		
		if(user != null)
		{
			if(password.equals(user.getPassword()))
			{
				
				session = req.getSession();
				session.setAttribute("user", user);
				
				resp.sendRedirect("HomeServlet");
			}
			else
			{
				resp.sendRedirect("IncorrectPwd.jsp");
			}
		}
		else
		{
			resp.sendRedirect("register.html");
		}
	}
}
