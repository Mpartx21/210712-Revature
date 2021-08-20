package com.miguel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.miguel.Employee;
import com.miguel.EmployeeDAO;
import com.miguel.EmployeeDAOFactory;

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
			EmployeeDAO dao = EmployeeDAOFactory.getDao();

			if(dao.addEmployee(employee)) {
				out.println("Sorry it did add");
				RequestDispatcher rd = request.getRequestDispatcher("add.html");
				rd.include(request, response);
			}else{
				out.println("Sorry didnt add");
				RequestDispatcher rd = request.getRequestDispatcher("add.html");
				rd.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
