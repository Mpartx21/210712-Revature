package com.revature;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
		System.out.println("This is get method of my servlet");
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		out.print("<h1>Get Method Called</h1>");
		out.print(new Date().toString());
	}
	
//	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
//		System.out.println("This is post method of my servlet");
//		res.setContentType("text/html");
//		
//		PrintWriter out = res.getWriter();
//		out.print("<h1>post Method called</h1>");
//		out.print(new Date().toString());
//	}
}
