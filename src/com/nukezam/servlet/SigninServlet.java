package com.nukezam.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nukezam.dao.Dbutil;
import com.nukezam.dao.UserDao;
import com.nukezam.model.User;

/**
 * Servlet implementation class SigninServlet
 */
@WebServlet(urlPatterns = "/signin", name = "signin")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Dbutil dbutil = new Dbutil();
    UserDao userDao = new UserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		request.setAttribute("email", email);
		request.setAttribute("password", password);
		if(email.isEmpty() || password.isEmpty()){
			request.setAttribute("error", "Username or Password is null");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		User user = new User(email, password);
		Connection con = null;
		try{
			con = dbutil.getCon();
			User currentUser = userDao.signin(con, user);
			if(currentUser == null){
				request.setAttribute("error", "username or password wrong");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else{

                HttpSession session = request.getSession();
                session.setAttribute("currentUser", currentUser);
                if (currentUser.getRole() == 0) {
                    response.sendRedirect("admin/index.jsp");
                } else if (currentUser.getRole() == 1){
                    response.sendRedirect("teacher/index.jsp");
                } else {
                    response.sendRedirect("student/index.jsp");
                }

			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				dbutil.closeCon(con);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	
	}

}
