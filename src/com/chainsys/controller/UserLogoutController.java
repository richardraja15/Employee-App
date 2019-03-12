package com.chainsys.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController This servlet is used to close
 * the session
 */
@WebServlet("/UserLogoutController")
public class UserLogoutController extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		session.removeAttribute("ID");
		session.invalidate();
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("UserLogin.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
