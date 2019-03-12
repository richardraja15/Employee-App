package com.chainsys.controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class UpdateController This servlet fetch employee
 * details to perform update operation
 */
@WebServlet("/EmployeeUpdateController")
public class EmployeeUpdateController extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		Employee employee = new Employee();
		int empId = Integer.parseInt(request.getParameter("id"));
		employee.setId(empId);
		EmployeeDAO employeeDAO = new EmployeeDAO();
		DepartmentDAO departmentDAO = new DepartmentDAO();
		PositionDAO positionDAO = new PositionDAO();
		ArrayList<Department> dList = new ArrayList<Department>();
		ArrayList<Position> pList = new ArrayList<Position>();
		EmployeeValidator employeeValidator = new EmployeeValidator();
		try {
			if (employeeValidator.validatById(employee)) {
				employee = employeeDAO.FindById(empId);

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
		}
	}
}
