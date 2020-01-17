package com.mvc.dao;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.mvc.bean.RegisterBean;
import com.mvc.util.DBConnection;

public class LoginDao {
	public RegisterBean authenticateUser(RegisterBean loginBean)
	 {
		
	     String userName = loginBean.getUserName(); //Keeping user entered values in temporary variables.
		 String password = loginBean.getPassword();
		 
		Connection con = null;
		 Statement statement = null;
		 ResultSet resultSet = null;
		 
		String userNameDB = "";
		 String passwordDB = "";
	
		 try
		 {
		 con = DBConnection.createConnection(); //establishing connection
		 statement = con.createStatement(); //Statement is used to write queries. Read more about it.
		 resultSet = statement.executeQuery("select * from users"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
		 
			while(resultSet.next()) // Until next row is present otherwise it return false
			 {
			  userNameDB = resultSet.getString("userName"); //fetch the values present in database
			  passwordDB = resultSet.getString("password");
			 
				   if(userName.equals(userNameDB) && password.equals(passwordDB))
				   {
					   loginBean.setadmin(resultSet.getString("admin"));
				      return loginBean; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
				   }
			 }
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		 return loginBean; // Just returning appropriate message otherwise
		 }
		
		public ArrayList<RegisterBean> getAllUser()
		{
			 Connection con = null;
			 Statement statement = null;
			 ResultSet resultSet = null;
			 RegisterBean loginBean = new RegisterBean();
			 //int flag=0;
		
			 
			ArrayList<RegisterBean> outer = new ArrayList<RegisterBean>();
			//ArrayList<RegisterBean> inner = new ArrayList<RegisterBean>();
			 
			 try
			 {
			 con = DBConnection.createConnection(); //establishing connection
			 statement = con.createStatement(); //Statement is used to write queries. Read more about it.
			 resultSet = statement.executeQuery("select * from users"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
			 
		
		while(resultSet.next())
			 	{
					loginBean = new RegisterBean();
					loginBean.setadmin(resultSet.getString("admin"));
					loginBean.setFullName(resultSet.getString("fullName").toString());
					loginBean.setEmail(resultSet.getString("email").toString());
					loginBean.setUserName(resultSet.getString("userName"));
					loginBean.setPassword(resultSet.getString("password"));
					outer.add(loginBean);
					
				
			 	}
				//outer.add(inner);
			 	return outer;
			 
			 }
			
			 catch(SQLException e)
			 {
			 e.printStackTrace();
			 }
			 return outer; // Just returning appropriate message otherwise
		}
		public RegisterBean getUser(RegisterBean loginBean)
		{
			 String userName = loginBean.getUserName(); //Keeping user entered values in temporary variables.
			 String password = loginBean.getPassword();
			 
			Connection con = null;
			 Statement statement = null;
			 ResultSet resultSet = null;
			 //int flag=0;
			String userNameDB = "";
			 String passwordDB = "";
			 try
			 {
			 con = DBConnection.createConnection(); //establishing connection
			 statement = con.createStatement(); //Statement is used to write queries. Read more about it.
			 resultSet = statement.executeQuery("select * from users"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
			 
				while(resultSet.next()) // Until next row is present otherwise it return false
				 {
				  userNameDB = resultSet.getString("userName"); //fetch the values present in database
				  passwordDB = resultSet.getString("password");
				 
					   if(userName.equals(userNameDB) && password.equals(passwordDB))
					   {
						   loginBean.setadmin(resultSet.getString("admin"));
						   loginBean.setEmail(resultSet.getString("email"));
						   loginBean.setFullName(resultSet.getString("fullName"));
						   loginBean.setPassword(resultSet.getString("password"));
						   loginBean.setUserName(resultSet.getString("userName"));
					      return loginBean; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
					   }
				 }
			 }
			 catch(SQLException e)
			 {
			 e.printStackTrace();
			 }
			 return loginBean; 
		}
	 }

