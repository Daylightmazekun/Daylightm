package com.nukezam.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nukezam.dao.AdminDao;
import com.nukezam.dao.Dbutil;
import com.nukezam.model.Notes;

/**
 * Servlet implementation class NotesdeleteServlet
 */
@WebServlet(urlPatterns = "/notesdelete", name = "notesdelete")
public class NotesdeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Dbutil dbutil = new Dbutil();
    AdminDao adminDao = new AdminDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotesdeleteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String notes_id = new String(request.getParameter("notes_id").getBytes("ISO-8859-1"), "UTF-8");
		
		Notes notes = new Notes();
		Connection con = null;
		
		notes.setNotes_id(notes_id);
		
		try{
			con = dbutil.getCon();
			adminDao.noteDelete(con, notes);
			response.sendRedirect("admin/index.jsp");
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}

}
