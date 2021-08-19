package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyLoginServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		if(username == null || password == null) {
			out.print("Sorry Empty Username || Password");
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
			
		}else if(username.equals("a") && password.equals("1")){
			request.getRequestDispatcher("navbar.html").include(request, response);
			out.println("You are successfully logged in!");
			out.println("<br>Welcome "+ username);
			
			Cookie cook = new Cookie("username",username);			
			response.addCookie(cook);
		}else {
			out.print("Sorry Invalid Username || Password");
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
		}
		out.close();
	}
}
