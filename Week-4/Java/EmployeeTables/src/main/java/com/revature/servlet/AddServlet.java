package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.revature.dao.EmployeeDAOFactory;
import com.revature.model.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adds")
public class AddServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		
		Employee employee = new Employee(name,email,gender,country);
	
		try {
			EmployeeDAOFactory.getDAO().addEmployee(employee);
		} catch (SQLException e) {
			out.println("Sorry didnt add");
			RequestDispatcher rd = request.getRequestDispatcher("add.html");
			rd.include(request, response);
		}
		out.println("Sorry it did add");
		RequestDispatcher rd = request.getRequestDispatcher("add.html");
		rd.include(request, response);
		
	}	
}
