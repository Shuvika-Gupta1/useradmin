package com.mvc.dao;
import java.sql.Connection;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
//import com.mvc.bean.DeleteBean;
import com.mvc.bean.RegisterBean;
//import com.mvc.bean.LoginBean;
import com.mvc.util.DBConnection;
//import com.mysql.jdbc.PreparedStatement;
public class DeleteDao {
	
	public  String authenticateUser(RegisterBean registerBean)
	 {
	 
	String userName = registerBean.getUserName();
	// Statement statement = null;
	// ResultSet resultSet = null;
	 java.sql.PreparedStatement preparedStatement = null;
	// String userNameDB = "";
	 try
	 {
		 /*Connection con = DBConnection.createConnection();
		 String sql = "DELETE FROM users where userName='"+userName+"'";
		 preparedStatement = con.prepareStatement(sql);
		 statement = con.createStatement(); //Statement is used to write queries. Read more about it.
		 resultSet = statement.executeQuery("select userName,password,admin from users");
		
			
			preparedStatement = (PreparedStatement) con.prepareStatement(sql);
			resultSet=preparedStatement.executeUpdate();
		 resultSet=preparedStatement.execute*/
		 String sql = "DELETE FROM users where userName='"+userName+"'";
			Connection connection = DBConnection.createConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			boolean flag = true;
		 if(flag==true) // Until next row is present otherwise it return false
		 {
			
			return "User Deleted Successfully";
			
		 }
		 }
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		 	return "User Deletion Unsuccessfully"; // Just returning appropriate message otherwise
		 }
}

