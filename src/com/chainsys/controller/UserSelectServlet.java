package com.chainsys.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsy.model.User;
import com.chainsys.DAO.UserDAO;

/**
 * Servlet implementation class UserSelectServlet This servlet is used to fetch
 * and display specific user details
 */
@WebServlet("/UserSelectServlet")
public class UserSelectServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		int empId = Integer.parseInt(request.getParameter("id"));
		User user = new User();
		UserDAO userDAO = new UserDAO();
		try {
			user = userDAO.FindById(empId);
			if (!(user == null)) {

				request.setAttribute("USER", user);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("UserSearch.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("ERROR_MSG",
						"Unable to fetch user details");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("UserSelect.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}