package com.chainsys.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsy.model.Employee;
import com.chainsys.DAO.EmployeeDAO;
import com.chainsys.DAO.UserDAO;
import com.chainsys.exceptioncontroller.EmployeeValidator;

/**
 * Servlet implementation class DeleteServlet This servet is used to delete
 * existing Employee
 */
@WebServlet("/EmployeeDeleteServlet")
public class EmployeeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		int empId = Integer.parseInt(request.getParameter("id"));
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Employee employee = new Employee();
		employee.setId(empId);
		EmployeeValidator employeeValidator = new EmployeeValidator();
		UserDAO userDAO = new UserDAO();
		try {
			if (employeeValidator.validatById(employee)) {
				employee = employeeDAO.FindById(empId);

				if (!(employee == null)) {
					userDAO.deleteInfo(empId);
					userDAO.deleteUserLogin(empId);
					employeeDAO.deleteById(empId);
					ArrayList<Employee> list = employeeDAO.FindAll();
					request.setAttribute("EMPLOYEE", list);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("EmployeeList.jsp");
					dispatcher.forward(request, response);
				} else {
					request.setAttribute("ERROR_MSG", "Id not found");
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("EmployeeDelete.jsp");
					dispatcher.forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("ERROR_MSG", e.getMessage());
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("EmployeeDelete.jsp");
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
