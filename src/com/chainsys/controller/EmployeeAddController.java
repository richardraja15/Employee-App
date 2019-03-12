package com.chainsys.controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsy.model.Department;
import com.chainsy.model.Position;
import com.chainsys.DAO.DepartmentDAO;
import com.chainsys.DAO.PositionDAO;

/**
 * Servlet implementation class AddController This servlet is used to fetch data
 * for Add Operation
 */
@WebServlet("/EmployeeAddController")
public class EmployeeAddController extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		DepartmentDAO departmentDAO = new DepartmentDAO();
		PositionDAO positionDAO = new PositionDAO();
		try {
			ArrayList<Department> arrayList = new ArrayList<Department>();
			arrayList = departmentDAO.select();
			ArrayList<Position> List = new ArrayList<Position>();
			List = positionDAO.select();
			request.setAttribute("DEPARTMENT", arrayList);
			request.setAttribute("POSITION", List);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("EmployeeAdd.jsp");
			dispatcher.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}