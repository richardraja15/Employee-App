package com.chainsys.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsy.model.User;
import com.chainsys.DAO.UserDAO;

/**
 * Servlet implementation class UserSelectServlet
 */
@WebServlet("/UserSelectServlet")
public class UserSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		User user = new User();
		UserDAO userDAO = new UserDAO();
		try {
			user = userDAO.FindById(id);
			request.setAttribute("USER", user);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("UserSearch.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("ERROR_MSG",e.getMessage());
			RequestDispatcher dispatcher=request.getRequestDispatcher("UserLogin.jsp");
			dispatcher.forward(request, response);

		}
		

	}

}
