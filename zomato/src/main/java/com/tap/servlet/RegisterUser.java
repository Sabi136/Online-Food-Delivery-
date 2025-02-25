package com.tap.servlet;

 
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.DAO.UserDAO;
import com.tap.DaoIMPL.UserDaoImpl;
import com.tap.entity.User;


/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/addUser")
public class RegisterUser extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String user_name = req.getParameter("user_name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		
		User u = new User(user_name, email, password, address);
		
		UserDAO udaoimpl = new UserDaoImpl();
		
		udaoimpl.addUser(u);
		System.out.println("Data inserted");
		
		resp.sendRedirect("login.html");	
		}
}
