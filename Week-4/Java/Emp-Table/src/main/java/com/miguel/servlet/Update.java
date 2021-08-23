package com.miguel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.miguel.Employee;
import com.miguel.EmployeeDAOFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/submitupdate")
public class Update extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession sesh = request.getSession();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		
		Employee employee = (Employee) sesh.getAttribute("employee");
		
		employee.setName(name);
		employee.setEmail(email);
		employee.setGender(gender);
		employee.setCountry(country);
		
		try {
			EmployeeDAOFactory.getDao().updateEmployee(employee);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("viewforupdate").forward(request, response);
	}	
}
