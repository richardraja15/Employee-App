package com.chainsys.controller;

import java.io.IOException;
import java.time.LocalDate;
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
 * Servlet implementation class UpdateServlet This servlet performs update
 * operation
 */
@WebServlet("/EmployeeUpdateServlet")
public class EmployeeUpdateServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		int empId = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		LocalDate joiningDate = LocalDate.parse(request
				.getParameter("joiningDate"));
		int departmentId = Integer.parseInt(request
				.getParameter("departmentId"));
		int positionId = Integer.parseInt(request.getParameter("positionId"));
		System.out.println(departmentId);
		Department department = new Department();
		department.setId(departmentId);
		Position position = new Position();
		position.setId(positionId);
		Employee employee = new Employee();
		employee.setId(empId);
		employee.setName(name);
		employee.setJoiningDate(joiningDate);
		employee.setDepartment(department);
		employee.setPosition(position);
		EmployeeDAO employeeDAO = new EmployeeDAO();
		EmployeeValidator employeeValidator = new EmployeeValidator();
		try {
			if (employeeValidator.validateAdd(employee)) {
				employeeDAO.Update(employee);
				Employee employee2 = new Employee();
				employee2 = employeeDAO.FindById(empId);
				request.setAttribute("EMPLOYEE", employee2);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("EmployeeSearch.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception E) {
			E.printStackTrace();
			request.setAttribute("ERROR_MSG", E.getMessage());

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("EmployeeUpdateOperation.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
