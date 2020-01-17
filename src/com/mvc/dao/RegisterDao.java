package com.mvc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.Statement;

//import javax.servlet.http.HttpServletRequest;

//import com.mvc.bean.EditBean;
import com.mvc.bean.RegisterBean;
import com.mvc.util.DBConnection;
public class RegisterDao {
	
	public String registerUser(RegisterBean registerBean)
	 {
		/*String fullName = registerBean.getFullName();
		 String email = registerBean.getEmail();
		 String userName = registerBean.getUserName();
		 String password = registerBean.getPassword();
		 String admin = registerBean.getadmin();
	
	 try
	 {
		 Connection con = null;
		 con = DBConnection.createConnection();
		 PreparedStatement preparedStatement=null;
		 if(!fullName.isEmpty() && !email.isEmpty() && !userName.isEmpty() && !password.isEmpty())
		 {
	 String query = "insert into users(srno,fullName,email,userName,password,admin) values (NULL,?,?,?,?,?)"; //Insert user details into the table 'USERS'
	 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
	 preparedStatement.setString(1, fullName);
	 preparedStatement.setString(2, email);
	 preparedStatement.setString(3, userName);
	 preparedStatement.setString(4, password);
	 preparedStatement.setString(5, admin);
	 int i= preparedStatement.executeUpdate();
		 
	 if (i!=0)  //Just to ensure data has been inserted into the database
	 return "User Registered Successfully"; 
	 }
		 else {
			 return "Please fill all the element";
		 }
	 }
	 catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
	 
	 return "There is an unknown error"; */ // On failure, send a message from here.
		String fullName = registerBean.getFullName();
		 String email = registerBean.getEmail();
		 String userName = registerBean.getUserName();
		 String password = registerBean.getPassword();
		 String admin = registerBean.getadmin();
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 
		 try
		 {
		 con = DBConnection.createConnection();
		 String query = "insert into users(srno,fullName,email,userName,password,admin) values (NULL,?,?,?,?,?)"; //Insert user details into the table 'USERS'
		 preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
		 preparedStatement.setString(1, fullName);
		 preparedStatement.setString(2, email);
		 preparedStatement.setString(3, userName);
		 preparedStatement.setString(4, password);
		 preparedStatement.setString(5, admin);
		 int i= preparedStatement.executeUpdate();
		 preparedStatement.executeQuery();
			 if (i!=0) 
			 	return "User Registered Successfully"; 
			 	 else {
					 return "Please fill all the element";
				 }
		}
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		
		 return "There is an unknown error";  
	 }
	public String authenticateUser(RegisterBean registerBean)
	 {
		
		
		/*String fullName = registerBean.getFullName();
		 String email = registerBean.getEmail();
		 String userName1 = registerBean.getUserName();
		 String password = registerBean.getPassword();
		Connection con1 = null;
		String fullName = "Shuvika";
		 String email = "abc@gmail.com";
		 String userName1 = "Tarun";
		 String password = "445566";
		 PreparedStatement preparedStatement = null;
		try
		{
			con1 = DBConnection.createConnection();
			 
			 String query1 = "UPDATE users SET fullName = '\"+fullName+\"', \"\r\n" + 
			 		"					+ \"email = '\"+email+\"', password = '\"+password+\"' where userName= '\"+userName1";
			
			String query1 = "UPDATE users SET fullName="+fullName +",email="+email+",PASSWORD="+password+" WHERE username="+userName1;
			String query1= "UPDATE users SET fullName = '"+fullName+"',email = '"+email+"', password = '"+password+"' where userName= '"+userName1+"'";
			
			 preparedStatement = con1.prepareStatement(query1); //Making use of prepared statements here to insert bunch of data
			 preparedStatement.setString(1, fullName);
			 preparedStatement.setString(2, email);
			 preparedStatement.setString(3, userName1);
			 preparedStatement.setString(4, password);
			 int i= preparedStatement.executeUpdate();
			 if (i!=0)  //Just to ensure data has been inserted into the database
				 return registerBean; 
		}
		catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
			return registerBean;*/ // Just returning appropriate message otherwise
		String fullName = registerBean.getFullName();
		 String email = registerBean.getEmail();
		 String userName = registerBean.getUserName();
		 String password = registerBean.getPassword();
		// String admin = registerBean.getadmin();
		 Connection con = null;
		 PreparedStatement preparedStatement = null;
		 try
		 {
		 con = DBConnection.createConnection();
		 String query1 = "UPDATE users SET fullName='"+fullName +"',email='"+email+"',password='"+password+"' WHERE userName='"+userName+"'";
		 preparedStatement = con.prepareStatement(query1);
		 int i= preparedStatement.executeUpdate();
		 if (i!=0) 
			 	return "User Updated Successfully"; 
			 	 
		}
		 catch(SQLException e)
		 {
		 e.printStackTrace();
		 }
		
		 return "There is an unknown error";
	 }
	public RegisterBean CheckUser(RegisterBean registerBean)
	 {
		
		
		Connection con1=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
   String userName=registerBean.getUserName();
   String fullName = registerBean.getFullName();
	 String email = registerBean.getEmail();
	 String password = registerBean.getPassword();
    
	try
	{
		
		con1 = DBConnection.createConnection();
		String queryString = "select * from users where userName='"+userName+"'";
       // doc=statement.executeQuery(queryString); 
		//statement=con1.createStatement();
		//pst.setString(1,userName);
		pst=con1.prepareStatement(queryString);
		rs = pst.executeQuery();
		if(rs.next())
		{
			fullName=rs.getString(2);
			registerBean.setFullName(fullName);
			email=rs.getString(3);
			registerBean.setEmail(email);
			password=rs.getString(4);
			registerBean.setPassword(password);
			return registerBean;
		}
     
		
	}
	catch(SQLException e)
	 {
	 e.printStackTrace();
	 }
		return registerBean; // Just returning appropriate message otherwise
	 }

}
