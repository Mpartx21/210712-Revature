package com.revature.calculator.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.revature.calculator.MathExpressions;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CalculateServlet extends HttpServlet {
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse respond) throws IOException {
		respond.setContentType("text/html");
		PrintWriter writer = respond.getWriter();
		Double first = null;
		Double second = null;
		try {
			first = Double.parseDouble(request.getParameter("first_num"));
			second = Double.parseDouble(request.getParameter("second_num"));
		}catch(Exception e) {
			writer.println("<h1>Entered Nothing</h1>");
			writer.println("<a href='Servlet-demo-app/calculator.html'>Calculator</a>");
		}
		

			String math = request.getParameter("math");
			switch(math) {
			 	case "add":
			 		double add = MathExpressions.add(first,second);
			 		writer.println("<h1>"+first+"+"+second+"="+add+"</h1>");
			 		break;
			 	case "sub":
			 		double sub = MathExpressions.sub(first,second);
			 		writer.println("<h1>"+first+"-"+second+"="+sub+"</h1>");
			 		break;
			 	case "multi":
			 		double multi = MathExpressions.multi(first,second);
			 		writer.println("<h1>"+first+"*"+second+"="+multi+"</h1>");
			 		break;
			 	case "divide":
			 		double divide = MathExpressions.divide(first,second);
			 		writer.println("<h1>"+first+"/"+second+"="+divide+"</h1>");
			 		break;
			 	default:
			 		writer.print("<h1>Nothing to Math With</h1>");
			}
		writer.println("<h1><a href='calculator.html'>Calculator</a></h1>");
	}
	
	public boolean isNull(Double x,Double y) {
		if(x == null||y == null) {
			return true;
		}else {
			return false;
		}
	}
}
