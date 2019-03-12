package com.chainsys.controller;

import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsy.model.Employee;
import com.chainsys.DAO.EmployeeDAO;

/**
 * Servlet implementation class SelectController This servlet is used to Fetch
 * employee based on specific id
 */
@WebServlet("/EmployeeSelectController")
public class EmployeeSelectController extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		try {
			ArrayList<Employee> arrayList = new ArrayList<Employee>();
			arrayList = employeeDAO.FindAll();
			if (!(arrayList.isEmpty())) {
				request.setAttribute("EMPLOYEE", arrayList);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("EmployeeList.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("ERROR_MSG", "NO EMPLOYEES TO DISPLAY");
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("EmployeeList.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}