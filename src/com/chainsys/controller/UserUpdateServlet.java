package com.chainsys.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsy.model.Employee;
import com.chainsy.model.User;
import com.chainsys.DAO.UserDAO;

/**
 * Servlet implementation class UserUpdateServlet This servlet performs update
 * operation
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		String emailId = request.getParameter("emailId");
		long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
		String address = request.getParameter("address");
		Employee employee = new Employee();
		employee.setId(id);
		User user = new User();
		user.setEmailId(emailId);
		user.setPhoneNumber(phoneNumber);
		user.setAddress(address);
		user.setEmployee(employee);
		UserDAO userDAO = new UserDAO();
		try {
			User user2 = new User();
			userDAO.Update(user);
			user2 = userDAO.FindById(id);
			request.setAttribute("USER", user2);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("UserSearch.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("ERROR_MSG", e.getMessage());
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("UserUpdateOperation.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
