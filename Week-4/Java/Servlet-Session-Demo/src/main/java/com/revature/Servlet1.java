package com.revature;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse respond) throws IOException {
	try (PrintWriter writer = respond.getWriter()){
		writer.println("<!DOCTYPE html>");
		writer.println("<HTML>");
		writer.println("<Head>");
		writer.println("<title>Servlet State Managment</title>");
		writer.println("</Head>");
		writer.println("<body>");
		String name = request.getParameter("name");
		Cookie c = null;
		boolean flag = false;
		
		
		if(name ==null ) {
			Cookie[] cookies = request.getCookies();
				for(Cookie cookie: cookies) {
					String tname = cookie.getName();
					if(tname.equals("user_name")) {
						flag = true;
						name = cookie.getValue();
				}
			}
		}else {
			writer.println("<h1>Hello " +name+" Welcome to my website</h1>");
		}
		
		if(flag) {
			writer.println("<h1>Hello " +name+" Welcome back to my website</h1>");
		}
		writer.println("<h1><a href='servlet2'>Go to Servlet 2</a>");
		c = new Cookie("user_name",name);
		respond.addCookie(c);
		writer.println("</body>");
		writer.println("</html>");
		}
	}

}
