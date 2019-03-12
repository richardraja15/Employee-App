package com.chainsys.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.DAO.UserDAO;

/**
 * Servlet implementation class UserLoginController This servlet validates user
 * login
 */
@WebServlet("/UserLoginController")
public class UserLoginController extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UserDAO userDAO = new UserDAO();
		try {
			if (userDAO.validateLogin(userName, password)) {
				int id = userDAO.getId(userName);
				HttpSession session = request.getSession();
				session.setAttribute("ID", id);
				RequestDispatcher rd = request
						.getRequestDispatcher("UserHome.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("ERROR_MSG",
						"Invalid UserName and Password");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("UserLogin.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
