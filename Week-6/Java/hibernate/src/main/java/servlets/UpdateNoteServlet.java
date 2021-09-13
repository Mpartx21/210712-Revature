package servlets;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transaction;

import org.hibernate.Session;

import entities.Note;
import helper.FactoryProvider;

public class UpdateNoteServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse respone) {
		try {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int noteId = Integer.parseInt(request.getParameter("noteId").trim());
			
			Session sesh = FactoryProvider.getSesh().openSession();
			
			Transaction tran =(Transaction) sesh.beginTransaction();
			Note note = sesh.get(Note.class,noteId);
			note.setTitle(title);
			note.setCreated(new Date());
			
			sesh.save(note);
			tran.commit();
			sesh.close();
			respone.setContentType("text/html");
			PrintWriter out = respone.getWriter();
			
			out.println("<h1>Note is added </h1>");
			out.println("<h1><a href=''>View All NOtes</a> </h1>");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
