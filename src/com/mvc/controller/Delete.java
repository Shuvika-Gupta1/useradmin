package com.mvc.controller;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import com.mvc.bean.DeleteBean;
import com.mvc.bean.RegisterBean;
//import com.mvc.bean.LoginBean;
import com.mvc.dao.DeleteDao;
//import com.mvc.dao.RegisterDao;
//import com.mvc.dao.LoginDao;
/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String userName = request.getParameter("id");
		
		RegisterBean registerBean = new RegisterBean();
		 registerBean.setUserName(userName);
		 DeleteDao deleteDao = new DeleteDao();
		 String userValidate = deleteDao.authenticateUser(registerBean);
		 
		 if(userValidate.equals("User Deleted Successfully"))
		 {
			 request.setAttribute("userName", userName); 
			 request.getRequestDispatcher("/Home.jsp").forward(request, response);
		 }
		 else
		 {
		 request.setAttribute("errMessage", userValidate); 
		 request.getRequestDispatcher("/Delete.jsp").forward(request, response);
		 }
	}

}
