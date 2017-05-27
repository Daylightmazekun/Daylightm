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
import com.nukezam.model.UserAdd;

/**
 * Servlet implementation class UseraddServlet
 */
@WebServlet(urlPatterns = "/UseraddServlet", name = "useradd")
public class UseraddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Dbutil dbutil = new Dbutil();
	AdminDao adminDao = new AdminDao();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UseraddServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		String school_num = new String(request.getParameter("school_num").getBytes("ISO-8859-1"), "UTF-8");
		String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
		String sex = new String(request.getParameter("sex").getBytes("ISO-8859-1"), "UTF-8");
		String grade = new String(request.getParameter("grade").getBytes("ISO-8859-1"), "UTF-8");
		String school = new String(request.getParameter("school").getBytes("ISO-8859-1"), "UTF-8");
		String major = new String(request.getParameter("manjor").getBytes("ISO-8859-1"), "UTF-8");
		String qq = new String(request.getParameter("qq").getBytes("ISO-8859-1"), "UTF-8");
		String phone = new String(request.getParameter("phone").getBytes("ISO-8859-1"), "UTF-8");
		String email = new String(request.getParameter("email").getBytes("ISO-8859-1"), "UTF-8");
		String password = new String(request.getParameter("password").getBytes("ISO-8859-1"), "UTF-8");
		String adress = new String(request.getParameter("adress").getBytes("ISO-8859-1"), "UTF-8");
		String role = new String(request.getParameter("role").getBytes("ISO-8859-1"), "UTF-8");
		UserAdd userAdd = new UserAdd();
		Connection con = null;
		userAdd.setSchool_num(school_num);
		userAdd.setName(name);
		userAdd.setSchool(school);
		userAdd.setSex(sex);
		userAdd.setGrade(grade);
		userAdd.setMajor(major);
		userAdd.setQq(qq);
		userAdd.setPhone(phone);
		userAdd.setEmail(email);
		userAdd.setPassword(password);
		userAdd.setAddress(adress);
		userAdd.setRole(role);
		try{
			con = dbutil.getCon();
			adminDao.userAdd(con, userAdd);
			response.sendRedirect("admin/user.jsp");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
