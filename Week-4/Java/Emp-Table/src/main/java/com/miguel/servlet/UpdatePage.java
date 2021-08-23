package com.miguel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.miguel.Employee;
import com.miguel.EmployeeDAOFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/viewupdate")
public class UpdatePage extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("toUpdate");
		id = id.substring(0,id.length()-1);
		Employee employee = null;
		HttpSession sesh = request.getSession();
		try {
			 employee = EmployeeDAOFactory.getDao().employeeByID(Integer.parseInt(id));
			 sesh.setAttribute("employee", employee);
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
		
		out.println("<form id='updateemployee' action='submitupdate' method='GET'>"+
			"<h1>UPDATE</h1>"+
			"<div class='form-group'>"+
		
			"<input type='text' name='name' value="+employee.getName()+" class=''><br>"+
			"<input type'text' name='email' value="+employee.getEmail()+"><br>"+
			
			"<div class='form-check form-check-inline'>"+
				"<input class='form-check-input' id='m' type='radio' name='gender' value='male'>"+
				"<label class='form-check-label' for='m'>Male</label>"+
			"</div>	"+
			
			"<div class='form-check form-check-inline'>"+
				"<input class='form-check-input' id='f' type='radio' name='gender' value='female'>"+
				"<label class='form-check-label' for='f'>Female</label>"+
			"</div>	"+
			
			"<div class='form-check form-check-inline'>"+
				"<input class='form-check-input' type='radio' name='gender' value='other'>"+
				"<label class='form-check-label' for='o'>Other</label>"+
			"</div>"+
			"<br>"+
			"<select name='country'>"+
				"<option value='usa'>USA</option>"+
				"<option value='uk'>UK</option>"+
			"</select>"+
			"<input type='submit' value='Submit' >"+
		"</div>"+
	"</form>");
		
		request.getRequestDispatcher("viewall2.html");
	}
}
