package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("admin") && password.equals("123")){
			RequestDispatcher rd = request.getRequestDispatcher("welcome");
			rd.forward(request, response);
		}else{
			out.print("Sorry invalid username and password");
			RequestDispatcher rd = request.getRequestDispatcher("/index2.html");
			rd.include(request, response);
			
		}
	}
}
