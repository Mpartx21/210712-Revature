package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SeshLogout extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession sesh = request.getSession();
		String username =(String)sesh.getAttribute("uname");
		String password =(String)sesh.getAttribute("pword");
		
		
		if(username == null || password == null) {
			out.print("Sorry Empty Username || Password");
			RequestDispatcher rd = request.getRequestDispatcher("/sessionindex.html");
			rd.include(request, response);
			
		}else{
			sesh.invalidate();
			
			RequestDispatcher rd = request.getRequestDispatcher("/sessionindex.html");
			rd.include(request, response);
		}
	}	
}

