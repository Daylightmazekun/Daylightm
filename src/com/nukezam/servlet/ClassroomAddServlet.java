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
import com.nukezam.model.ClassRoom;

/**
 * Servlet implementation class ClassroomAddServlet
 */
@WebServlet(urlPatterns = "/classroomadd", name = "classroomadd")
public class ClassroomAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Dbutil dbutil = new Dbutil();
	AdminDao adminDao = new AdminDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassroomAddServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String location = new String(request.getParameter("location").getBytes("ISO-8895-1"),"UTF-8");
		String capacity = new String(request.getParameter("capacity").getBytes("IS-8895-1"),"UTF-8");
		
		ClassRoom classroom = new ClassRoom();
		Connection con = null;
		classroom.setCapacity(capacity);
		classroom.setLocation(location);
		
		try{
			con = dbutil.getCon();
			adminDao.classRoomAdd(con, classroom);
			response.sendRedirect("admin/classroom.jsp");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
