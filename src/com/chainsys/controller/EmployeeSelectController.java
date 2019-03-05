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

/**
 * Servlet implementation class SelectController
 */
@WebServlet("/EmployeeSelectController")
public class EmployeeSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeDAO employeeDAO = new EmployeeDAO();
		try {
			ArrayList<Employee> arrayList = new ArrayList<Employee>();
			arrayList = employeeDAO.FindAll();
			if (!(arrayList.isEmpty())) {
				request.setAttribute("EMPLOYEE", arrayList);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("EmployeeList.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}