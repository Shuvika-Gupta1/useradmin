package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
//import java.util.List;

import javax.servlet.RequestDispatcher;
//import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mvc.bean.RegisterBean;
import com.mvc.dao.LoginDao;
//import com.mvc.controller.GetResult;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		 String password = request.getParameter("password");
			
		
		RegisterBean loginBean = new RegisterBean(); //creating object for LoginBean class, which is a normal java class, contains just setters and getters. Bean classes are efficiently used in java to access user information wherever required in the application.
		ArrayList<RegisterBean> users = new ArrayList<RegisterBean>();
		
		loginBean.setUserName(userName); //setting the username and password through the loginBean object then only you can get it in future.
		 loginBean.setPassword(password);
		 
		LoginDao loginDao = new LoginDao(); //creating object for LoginDao. This class contains main logic of the application.
		
		
		RegisterBean userValidate = loginDao.authenticateUser(loginBean); //Calling authenticateUser function
		if(userValidate!=null)
		{
			if(userValidate.getadmin().equals("Yes"))//If function returns success string then user will be rooted to Home page
			{
				//flag=0;
				users=(loginDao.getAllUser());
				request.setAttribute("users", users);
				RequestDispatcher rd= request.getRequestDispatcher("/Show.jsp");
				rd.forward(request, response);
			}
			else
			{
				userValidate=loginDao.getUser(loginBean);
				request.setAttribute("user", userValidate);
				RequestDispatcher rd= request.getRequestDispatcher("/info.jsp");
				rd.forward(request, response);
			}
		}
		
			
		 }
		
		 }
		 
		

