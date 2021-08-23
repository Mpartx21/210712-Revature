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
@WebServlet("/delete")
public class Delete extends HttpServlet{
	
	public void doGet (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
				
		String[] iDS = request.getParameterValues("toDelete");
		
		for(String id: iDS) {
			try {
				id = id.substring(0,id.length()-1);
				EmployeeDAOFactory.getDao().deleteEmployee(Integer.parseInt(id));	
				} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher("viewfordelete").forward(request, response);

	}

}
