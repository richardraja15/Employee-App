package com.chainsys.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsy.model.Employee;
import com.chainsys.DAO.EmployeeDAO;
import com.chainsys.exceptioncontroller.EmployeeValidator;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/EmployeeSearchServlet")
public class EmployeeSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		int id = Integer.parseInt(request.getParameter("id"));
		employee.setId(id);
		EmployeeDAO employeeDAO = new EmployeeDAO();
		EmployeeValidator employeeValidator = new EmployeeValidator();
		try {
			if (employeeValidator.validatById(employee)) {
				employee = employeeDAO.FindById(id);
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
