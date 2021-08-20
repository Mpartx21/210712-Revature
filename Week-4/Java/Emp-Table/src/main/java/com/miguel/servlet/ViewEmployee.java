package com.miguel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.miguel.EmployeeDAOFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class ViewEmployee extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rd = request.getRequestDispatcher("viewall.html");
		out.println("<table border=1 width=50% height=50%>");
out.println("<tr><th>Employee ID</th><th>Employee Name</th><th>Employee Email</th><th>Employee Gender</th><th>Employee Country</th></tr>"); 
		
		try {
			EmployeeDAOFactory.getDao().getEmployess().forEach((employee)->{
out.println("<tr><td>"+employee.getId()+"</td><td>"+employee.getName()+"</td><td>"+employee.getEmail()+"</td><td>"+employee.getGender()+"</td><td>"+employee.getCountry()+"</td></tr>"); 
			});
			rd.include(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
