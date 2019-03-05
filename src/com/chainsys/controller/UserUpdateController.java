package com.chainsys.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsy.model.User;
import com.chainsys.DAO.UserDAO;

/**
 * Servlet implementation class UserUpdateController
 */
@WebServlet("/UserUpdateController")
public class UserUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    		User user=new User();
    		int id = Integer.parseInt(request.getParameter("id"));
    		UserDAO userDAO=new UserDAO();
    	try {
    			user= userDAO.FindById(id);
    			
    			 if(!(user==null)){
    			
    				 request.setAttribute("USER", user);
    				 RequestDispatcher dispatcher = request
    					.getRequestDispatcher("UserUpdateOperation.jsp");
    			dispatcher.forward(request, response);
    		
    			}
    			
    			} catch (Exception e) {
    			e.printStackTrace();
    			request.setAttribute("ERROR_MSG", e.getMessage());

    			RequestDispatcher dispatcher = request
    					.getRequestDispatcher("UserUpdateOperation.jsp");
    			dispatcher.forward(request, response);

    		}
    	

    	}

}
