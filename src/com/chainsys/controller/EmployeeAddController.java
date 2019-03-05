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
import com.chainsy.model.Position;
import com.chainsys.DAO.DepartmentDAO;
import com.chainsys.DAO.PositionDAO;

/**
 * Servlet implementation class AddController
 */
@WebServlet("/EmployeeAddController")
public class EmployeeAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DepartmentDAO departmentDAO=new DepartmentDAO();
		PositionDAO positionDAO=new PositionDAO();
		
		try{
			ArrayList<Department> arrayList=new ArrayList<Department>();
			arrayList = departmentDAO.select();
			ArrayList<Position> List=new ArrayList<Position>();
			List = positionDAO.select();
				
			request.setAttribute("DEPARTMENT", arrayList);
			request.setAttribute("POSITION",List);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("EmployeeAdd.jsp");
				dispatcher.include(request, response);
			
			
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}



}
}