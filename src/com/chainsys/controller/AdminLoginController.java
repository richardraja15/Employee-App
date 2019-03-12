package com.chainsys.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.DAO.AdminDAO;

/**
 * Servlet implementation class AdminLoginController This servlet is used to
 * Authenticate Admin Login
 */
@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		AdminDAO adminDAO = new AdminDAO();
		try {
			if (adminDAO.validateLogin(userName, password)) {
				RequestDispatcher rd = request
						.getRequestDispatcher("AdminHome.html");
				rd.forward(request, response);
			} else {
				request.setAttribute("ERROR_MSG",
						"Invalid Username or Password");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("AdminLogin.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
