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
 * Servlet implementation class NotesaddServlet
 */
@WebServlet("/NotesaddServlet")
public class NotesaddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Dbutil dbutil = new Dbutil();
	AdminDao adminDao = new AdminDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotesaddServlet() {
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
		String title = new String(request.getParameter("title").getBytes("ISO-8859-1"), "UTF-8");
		String start_time = new String(request.getParameter("start_time").getBytes("ISO-8859-1"), "UTF-8");
		String stop_time = new String(request.getParameter("stop_time").getBytes("ISO-8859-1"), "UTF-8");
		String description = new String(request.getParameter("description").getBytes("ISO-8859-1"), "UTF-8");
		
		Notes notes = new Notes();
		Connection con = null;
		notes.setTitle(title);
		notes.setStart_time(start_time);
		notes.setStop_time(stop_time);
		notes.setDescription(description);
		try{
			con = dbutil.getCon();
			adminDao.notesadd(con, notes);
			response.sendRedirect("admin/notemanage.jsp");
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
}
