package com.chainsys.controller;

import java.io.IOException;
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
import com.chainsys.DAO.DepartmentDAO;
import com.chainsys.DAO.EmployeeDAO;
import com.chainsys.DAO.PositionDAO;
import com.chainsys.exceptioncontroller.EmployeeValidator;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/EmployeeUpdateController")
public class EmployeeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		int id = Integer.parseInt(request.getParameter("id"));
		employee.setId(id);
		EmployeeDAO employeeDAO = new EmployeeDAO();
		DepartmentDAO departmentDAO = new DepartmentDAO();
		PositionDAO positionDAO = new PositionDAO();
		ArrayList<Department> dList = new ArrayList<Department>();
		ArrayList<Position> pList = new ArrayList<Position>();
		EmployeeValidator employeeValidator = new EmployeeValidator();
		try {
			if (employeeValidator.validatById(employee)) {
				employee = employeeDAO.FindById(id);

				if (!(employee == null)) {
					dList = departmentDAO.select();
					pList = positionDAO.select();

					request.setAttribute("EMPLOYEE", employee);
					request.setAttribute("DEPARTMENT", dList);
					request.setAttribute("POSITION", pList);
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("EmployeeUpdateOperation.jsp");
					dispatcher.forward(request, response);

				} else {
					request.setAttribute("ERROR_MSG", "Id not found!!!");
					RequestDispatcher dispatcher = request
							.getRequestDispatcher("EmployeeUpdate.jsp");
					dispatcher.forward(request, response);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("ERROR_MSG", e.getMessage());

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("EmployeeUpdate.jsp");
			dispatcher.forward(request, response);

		}

	}

}
