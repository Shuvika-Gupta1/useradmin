package com.candidjava;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Statement stmt;
	ResultSet rs;

	String sql;
	HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		
		//String un = request.getParameter("username");
        //String pw = request.getParameter("password");
       // HttpSession session = null;
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
			  Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");
			  
		       // PrintWriter out = response.getWriter();
		        System.out.println("This is EditRecord Servlet");
		        session= request.getSession();
		        String un =(String) session.getAttribute("username");
		        System.out.println(un);
		        sql ="select * from student where username='"+un+"' ";
		        System.out.println(sql);
		        stmt = con.createStatement();
		        rs = stmt.executeQuery(sql);
		        System.out.println("Resultset From EditRecord Servlet  ="+rs);
			  /*PreparedStatement ps = con.prepareStatement("select userName,pass from student where username=? and pass=?");
	            ps.setString(1, un);

	            ResultSet rs = ps.executeQuery();*/

	            if(rs.next() || rs.getString("admin")=="Yes")
	            {
	                System.out.println(rs.getString("name"));
	                System.out.println(rs.getString("username"));
	                System.out.println(rs.getString("pass"));
	                System.out.println(rs.getString("addr"));
	                System.out.println(rs.getString("age"));
	                System.out.println(rs.getString("percent"));
	                System.out.println(rs.getString("year"));
	                System.out.println(rs.getString("admin"));
	                
	            }
	           
	            	
	            
	        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally
        {

            try 
            {
            	
                	session.setAttribute("resultset", rs);
                    RequestDispatcher rd= request.getRequestDispatcher("info.jsp");
                    rd.forward(request, response);
            		
            	
            } 
            catch (Exception e) 
            {
                System.out.println("This is finally block info");
                e.printStackTrace();
            }
        }
        	
        }
	}


