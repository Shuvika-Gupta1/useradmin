package com.mvc.controller;

import java.io.IOException;
//import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.mvc.bean.RegisterBean;
//import com.mvc.dao.DeleteDao;
import com.mvc.dao.RegisterDao;
//import com.mvc.util.DBConnection;
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		
		 String fullName1 = request.getParameter("fullname");
		 String email = request.getParameter("email");
		 String userName = request.getParameter("username");
		 String admin = request.getParameter("admin");
		 String password = request.getParameter("password");
		 
		 RegisterBean registerBean = new RegisterBean();
		 registerBean.setFullName(fullName1);
		 registerBean.setEmail(email);
		 registerBean.setUserName(userName);
		 registerBean.setadmin(admin);
		 registerBean.setPassword(password);
		 String RED=request.getParameter("RED");
		 
		 
		 /*RegisterDao registerDao = new RegisterDao();
		 String userRegistered = registerDao.registerUser(registerBean);
		 
		 
			 if(userRegistered.equals("SUCCESS"))   //On success, you can display a message to user on Home page
			 {
				 request.getRequestDispatcher("/Home.jsp").forward(request, response);
			 }
			 else   //On Failure, display a meaningful message to the User.
			 {
			 request.setAttribute("errMessage", userRegistered);
			 request.getRequestDispatcher("/Register.jsp").forward(request, response);
			 }*/
		 if(RED.equals("Register"))
		 {
			 RegisterDao registerDao = new RegisterDao();
			 String userRegistered = registerDao.registerUser(registerBean);
			 if(userRegistered.equals("User Registered Successfully"))
			 {
				 request.getRequestDispatcher("/Home.jsp").forward(request, response);
			 }
			 else
			 {
				 
				 request.getRequestDispatcher("/Register.jsp").forward(request, response);
			 }
		 }
		 if(RED.equals("Edit"))
		 {
			 
			 RegisterDao registerDao = new RegisterDao();
			 
			 String userValidate = registerDao.authenticateUser(registerBean);
			 if(userValidate.equals("User Updated Successfully"))
			 {
				 request.getRequestDispatcher("/Home.jsp").forward(request, response);
			 }
			 else
			 {
				 
				 request.getRequestDispatcher("/Register.jsp").forward(request, response);
			 }
			 //request.getRequestDispatcher("/Home.jsp").forward(request, response);
		 }
		 if(RED.equals("Check"))
		 {
			 
			 RegisterDao registerDao = new RegisterDao();
			 registerBean.setUserName(userName);
			 RegisterBean userValidate = registerDao.CheckUser(registerBean);
			 
			 request.getRequestDispatcher("/Register.jsp").forward(request, response);
			/* request.setAttribute(fullName,userValidate.getFullName());
			 request.setAttribute(email,userValidate.getEmail());
			 request.setAttribute(password,userValidate.getPassword());
			 request.setAttribute(admin,userValidate.getadmin());
			 */
			 String fullName=(String) request.getAttribute(userValidate.getFullName().toString());
			 request.setAttribute(fullName1, fullName);
			 String email1=(String) request.getAttribute(userValidate.getEmail().toString());
			 request.setAttribute(email, email1);
			 String password1=(String) request.getAttribute(userValidate.getPassword().toString());
			 request.setAttribute(password, password1);
			 
			 /*String admin1=(String) request.getAttribute(userValidate.getadmin().);
			 request.setAttribute(fullName1, fullName);*/
		 }
		 
	}

}
