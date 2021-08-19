package com.revature;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse respond) throws IOException {
	try (PrintWriter writer = respond.getWriter()){
		writer.println("<!DOCTYPE html>");
		writer.println("<HTML>");
		writer.println("<Head>");
		writer.println("<title>Servlet State Managment</title>");
		writer.println("</Head>");
		writer.println("<body>");
	
		
		Cookie[] cookies = request.getCookies();
		String named = " ";
		boolean running = false;
		
		if(cookies == null) {
			writer.println("<h1> you are new user go to home page and submit your name");
		}else {
			for(Cookie cookie: cookies) {
				String tname = cookie.getName();
				if(tname.equals("user_name")) {
					running = true;
					named = cookie.getValue();
				}
			}
		}
		
		if(running) {
			writer.println("<h1>Hello " +named+" Welcome back to my website</h1>");
		}
		writer.println("<h1><a href='servlet1'>Go to Servlet 1</a>");
		writer.println("</body>");
		writer.println("</html>");
		}
	}
}
