package useradmin;


import java.sql.*;
public class sqlconnection {
	/*Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/useradmin", "root", "root");*/
	Connection dbConnection = null;
	   String dbName = "com.mysql.jdbc.Driver";
	   String userName = "root"; 
	   String password = "root";

	   public Connection getConnection() throws ClassNotFoundException, SQLException {
	      Class.forName(dbName);
	      dbConnection = DriverManager.getConnection(dbName,userName,password);
	      return dbConnection;
}
}