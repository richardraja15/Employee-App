package com.chainsys.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.DAO.UserDAO;

/**
 * Servlet implementation class UserLoginController
 */
@WebServlet("/UserLoginController")
public class UserLoginController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UserDAO userDAO=new UserDAO();
		try {
			if (userDAO.validateLogin(userName, password)){
				int id=userDAO.getId(userName);
				HttpSession session=request.getSession();
				session.setAttribute("ID",id);
				RequestDispatcher rd = request.getRequestDispatcher("UserHome.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("ERROR_MSG", "Invalid UserName and Password");
				RequestDispatcher dispatcher=request.getRequestDispatcher("UserLogin.jsp");
				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

	}

}
