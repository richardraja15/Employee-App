package com.chainsys.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsy.model.Department;
import com.chainsy.model.Employee;
import com.chainsy.model.Position;
import com.chainsys.DAO.EmployeeDAO;
import com.chainsys.exceptioncontroller.EmployeeValidator;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/EmployeeAddServlet")
public class EmployeeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		LocalDate joiningDate = LocalDate.parse(request
				.getParameter("joiningDate"));
		int departmentId = Integer.parseInt(request
				.getParameter("departmentId"));
		int positionId = Integer.parseInt(request.getParameter("positionId"));
		Department department = new Department();
		department.setId(departmentId);
		Position position = new Position();
		position.setId(positionId);
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setJoiningDate(joiningDate);
		employee.setDepartment(department);
		employee.setPosition(position);
		EmployeeDAO employeeDAO = new EmployeeDAO();
		EmployeeValidator validator = new EmployeeValidator();
		try {
			if (validator.validateAdd(employee)) {
		employeeDAO.addEmployee(employee);
				ArrayList<Employee> list = employeeDAO.FindAll();
				request.setAttribute("EMPLOYEE", list);

				RequestDispatcher dispatcher = request
						.getRequestDispatcher("EmployeeList.jsp");
				dispatcher.forward(request, response);
				}
			

		}

		catch (Exception E) {
			
            E.printStackTrace();
			request.setAttribute("ERROR_MSG", E.getMessage());

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("EmployeeAdd.jsp");
			dispatcher.forward(request, response);

		}

	}

}