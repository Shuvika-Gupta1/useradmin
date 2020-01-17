package com.mvc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import com.mvc.bean.EditBean;
import com.mvc.util.DBConnection;
public class EditDao {
	public String authenticateUser(EditBean editBean)
	 {
	String fullName = editBean.getFullName();
	 String email = editBean.getEmail();
	 String userName1 = editBean.getUserName();
	 String password = editBean.getPassword();
	Connection con1 = null;
	/*String fullName = "Shuvika";
	 String email = "abc@gmail.com";
	 String userName1 = "Tarun";
	 String password = "445566";*/
	 PreparedStatement preparedStatement = null;
	try
	{
		con1 = DBConnection.createConnection();
		 
		 /*String query1 = "UPDATE users SET fullName = '\"+fullName+\"', \"\r\n" + 
		 		"					+ \"email = '\"+email+\"', password = '\"+password+\"' where userName= '\"+userName1";*/
		
		/*String query1 = "UPDATE users SET fullName="+fullName +",email="+email+",PASSWORD="+password+" WHERE username="+userName1;*/
		String query1= "UPDATE users SET fullName = '"+fullName+"',email = '"+email+"', password = '"+password+"' where userName= '"+userName1+"'";
		
		 preparedStatement = con1.prepareStatement(query1); //Making use of prepared statements here to insert bunch of data
		 /*preparedStatement.setString(1, fullName);
		 preparedStatement.setString(2, email);
		 preparedStatement.setString(3, userName1);
		 preparedStatement.setString(4, password);*/
		 int i= preparedStatement.executeUpdate();
		 if (i!=0)  //Just to ensure data has been inserted into the database
			 return "SUCCESS3"; 
	}
	catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
		return "Oops.. Something went wrong there..!"; // Just returning appropriate message otherwise
	 }
}

