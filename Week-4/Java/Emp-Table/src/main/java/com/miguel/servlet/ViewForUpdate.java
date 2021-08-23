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
@WebServlet("/viewforupdate")
public class ViewForUpdate extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rd = request.getRequestDispatcher("viewall2.html");
		rd.include(request, response);
		
		out.println("<form action='viewupdate' method='POST'>");
		out.println("<table class='table' border=1 width=50% height=50%>");
out.println("<tr><th>Employee ID</th><th>Employee Name</th><th>Employee Email</th><th>Employee Gender</th><th>Employee Country</th><th>Update</th></tr>"); 
			
		try {
			EmployeeDAOFactory.getDao().getEmployess().forEach((employee)->{
		out.println("<tr><td>"+employee.getId()+"</td><td>"+employee.getName()+"</td><td>"+employee.getEmail()+"</td><td>"+employee.getGender()+"</td><td>"+employee.getCountry()+"</td><td><input name='toUpdate' type='radio' value="+employee.getId()+"/>Update</td</tr>"); 
			});
			out.println("</table>");
			out.println("<input type='submit' value='Update'>");
			out.println("</form>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

