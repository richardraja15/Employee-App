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
import com.chainsys.DAO.EmployeeDAO;
import com.chainsys.DAO.UserDAO;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/UserRegistrationController")
public class UserRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String emailId = request.getParameter("emailId");
		String confirmPassword = request.getParameter("confirmPassword");
		long phoneNumber =Long.parseLong(request.getParameter("phoneNumber")) ;
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		Employee employee = new Employee();
		employee.setId(id);
		User user = new User();
		user.setEmailId(emailId);
		user.setPhoneNumber(phoneNumber);
		user.setAddress(address);
		user.setUserName(userName);
		user.setPassword(password);
		user.setEmployee(employee);
		user.setGender(gender);
		EmployeeDAO employeeDAO = new EmployeeDAO();
		UserDAO userDAO = new UserDAO();
		String message;
		try {

			if (password.contentEquals(confirmPassword)) {
				if (employeeDAO.getId(id)) {
					if (userDAO.validateId(id)) {
						if (userDAO.getUserName(userName)) {

							userDAO.setUserInfo(user);
							userDAO.setUserName(user);
							message = "Registered";
						} else {
							// request.setAttribute("Message",
							// "Duplicate User Name!!!");
							message = "Username already taken";
						}
					} else {
						message = "Employee id already registered";
					}
				} else {
					message = "Employee id not enrolled";
				}
			} else {
				message = "Password and Confirm Password does not match";
			}
			request.setAttribute("MESSAGE", message);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("UserRegistration.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("MESSAGE", e.getMessage());
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("UserRegistration.jsp");
			dispatcher.forward(request, response);

		}

	}

}
