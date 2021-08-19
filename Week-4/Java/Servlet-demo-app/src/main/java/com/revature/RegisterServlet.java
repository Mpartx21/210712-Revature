package com.revature;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse respond) throws IOException {
		respond.setContentType("text/html");
		PrintWriter out = respond.getWriter();
		
//		out.print();
		String name = request.getParameter("user_name");
		String email = request.getParameter("user_email");
		String password = request.getParameter("user_password");
		String gender = request.getParameter("user_gender");
		String city = request.getParameter("user_city");
		String agreement = request.getParameter("agreement");
		if(agreement.equals("accepted")) {
			out.println("<h1>Name " + name +"</h1>");
			out.println("<h1>Email " + email +"</h1>");
			out.println("<h1>Password " + password +"</h1>");
			out.println("<h1>Gender " + gender +"</h1>");
			out.println("<h1>City " + city +"</h1>");
		}else {
			out.println("<h1>you have not accepted the terms and conditions");
		}
	}
}
