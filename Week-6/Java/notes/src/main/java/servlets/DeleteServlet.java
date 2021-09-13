package servlets;

import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transaction;

import org.hibernate.Session;

import entities.Note;
import helper.FactoryProvider;

public class DeleteServlet extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse respone) {
		try {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int noteId = Integer.parseInt(request.getParameter("noteId").trim());
			
			Session sesh = FactoryProvider.getSesh().openSession();
			
			Transaction tran =(Transaction) sesh.beginTransaction();
			Note note = sesh.get(Note.class,noteId);
			
			sesh.delete(note);
			tran.commit();
			sesh.close();
			respone.sendRedirect("");

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
	}
}
