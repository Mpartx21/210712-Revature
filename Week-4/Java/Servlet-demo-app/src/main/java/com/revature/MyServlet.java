package com.revature;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class MyServlet implements Servlet {
	ServletConfig config= null;

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.config=arg0;
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Service called");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<h1>Hello from Servlet</h1>");
		out.print("</body></html>");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Servlet is derstroyed");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.config;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "Servlet created by admin";
	}

	

	

}
