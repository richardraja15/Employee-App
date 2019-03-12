package com.chainsys.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsy.model.User;
import com.chainsys.DAO.UserDAO;

/**
 * Servlet implementation class UserUpdateController This servlet is used to
 * fetch details to perform update operation
 */
@WebServlet("/UserUpdateController")
public class UserUpdateController extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		User user = new User();
		int id = Integer.parseInt(request.getParameter("id"));
		UserDAO userDAO = new UserDAO();
		try {
			user = userDAO.FindById(id);
			if (!(user == null)) {
				request.setAttribute("USER", user);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("UserUpdateOperation.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("ERROR_MSG",
						"Unable to fetch user details");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("UserUpdate.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
