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
import com.chainsys.exceptioncontroller.EmployeeValidator;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/EmployeeDeleteServlet")
public class EmployeeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));

		EmployeeDAO employeeDAO = new EmployeeDAO();
		Employee employee = new Employee();
		employee.setId(id);
		EmployeeValidator employeeValidator = new EmployeeValidator();
		try {
			if (employeeValidator.validatById(employee)) {
				employee = employeeDAO.FindById(id);

				if (!(employee == null)) {
					employeeDAO.deleteById(id);

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
		} catch (Exception E) {
			E.printStackTrace();

			request.setAttribute("ERROR_MSG", E.getMessage());

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("EmployeeDelete.jsp");
			dispatcher.forward(request, response);

		}

	}

}
