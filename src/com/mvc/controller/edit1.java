package com.mvc.controller;


import java.io.IOException;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.Enumeration;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Enumeration;
//import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.bean.EditBean;

import com.mvc.dao.EditDao;

/**
 * Servlet implementation class edit1
 */
@WebServlet("/edit1")
public class edit1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit1() {
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
		String userName = request.getParameter("username");
		 String fullName = request.getParameter("fullname");
		 String email = request.getParameter("email");
		 String password = request.getParameter("password");
		EditBean editBean = new EditBean();
		 editBean.setUserName(userName);
		 editBean.setFullName(fullName);
		 editBean.setEmail(email);
		 editBean.setPassword(password);
		 EditDao editDao = new EditDao();
		 String userValidate = editDao.authenticateUser(editBean);
		 if(userValidate.equals("SUCCESS3"))
		 {
			/* request.setAttribute("userName", userName); 
			 System.out.println("Record Updated");*/
			 request.getRequestDispatcher("/Home.jsp").forward(request, response);
		 }
		 else   //On Failure, display a meaningful message to the User.
		 {
		 request.setAttribute("errMessage", userValidate);
		 request.getRequestDispatcher("/Edit.jsp").forward(request, response);
		 }
	}

}
