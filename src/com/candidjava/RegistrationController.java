package com.candidjava;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html");
		  PrintWriter out = response.getWriter();
		  String name = request.getParameter("fullname");
		  String userName = request.getParameter("userName");
		  String pass = request.getParameter("pass");
		  String addr = request.getParameter("address");
		  String age = request.getParameter("age");
		  String percent = request.getParameter("percent");
		  String year = request.getParameter("yop");
		  String admin = request.getParameter("admin");
		  if (name.isEmpty() || addr.isEmpty() || age.isEmpty() || percent.isEmpty() || year.isEmpty()) {
			   RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
			   out.println("<font color=red>Please fill all the fields</font>");
			   rd.include(request, response);
			  } 
		  else {
			  
			  try {
				  Class.forName("com.mysql.jdbc.Driver");
				  Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");
				  String query = "insert into student (name,username,pass,addr,age,percent,year,admin)values(?,?,?,?,?,?,?,?)";
				  PreparedStatement ps = con.prepareStatement(query);
				  ps.setString(1, name);
				    ps.setString(2, userName);
				    ps.setString(3, pass);
				    ps.setString(4, addr);
				    ps.setInt(5, Integer.parseInt(age));
				    ps.setString(6, percent);
				    ps.setString(7, year);
				    ps.setBoolean(8,Boolean.parseBoolean(admin));
				    
				    
				    
				    ps.executeUpdate(); 
				    System.out.println("successfuly inserted");
				    ps.close();
				    con.close();
			  }
			  catch (ClassNotFoundException | SQLException e) {
				    // TODO Auto-generated catch block
				    e.printStackTrace();
			}
			  
		}
	}

	

	

}
