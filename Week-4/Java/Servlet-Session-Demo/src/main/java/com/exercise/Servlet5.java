package com.exercise;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Servlet5 extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		
		// getting the value from query string
		String name = request.getParameter("name");
		out.print("Welcome "+ name);
		
		HttpSession sesh = request.getSession();
		sesh.setAttribute("uname", name);
		out.println("<a href='Servlet6'>Click here</a>");
		out.close();
	}
}