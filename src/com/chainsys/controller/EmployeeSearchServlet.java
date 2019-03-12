package com.chainsys.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsy.model.Employee;
import com.chainsys.DAO.EmployeeDAO;
import com.chainsys.exceptioncontroller.EmployeeValidator;

/**
 * Servlet implementation class SelectServlet This servlet is used to search for
 * specific id
 */
@WebServlet("/EmployeeSearchServlet")
public class EmployeeSearchServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		Employee employee = new Employee();
		int empId = Integer.parseInt(request.getParameter("id"));
		employee.setId(empId);
		EmployeeDAO employeeDAO = new EmployeeDAO();
		EmployeeValidator employeeValidator = new EmployeeValidator();
		try {
			if (employeeValidator.validatById(employee)) {
				employee = employeeDAO.FindById(empId);
				if (!(employee == null)) {
					request.setAttribute("EMPLOYEE", employee);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("EmployeeSearch.jsp");
					dispatcher.forward(request, response);
				} else {
					request.setAttribute("ERROR_MSG", "Id not found!!!");
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("EmployeeSelect.jsp");
					dispatcher.forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
