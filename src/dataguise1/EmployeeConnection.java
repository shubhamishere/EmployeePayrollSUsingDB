package dataguise1;

//import java.io.FileInputStream;
//import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class EmployeeConnection {
	
	String url = "jdbc:mysql://localhost:3306/employeedb";
	String user = "root";
	String pass = "";
	Connection con = null;
	
	public Connection getConnection() {
		
	    try {
	    	//registering/loading driver.
	    	Class.forName("com.mysql.jdbc.Driver");
	    	try {
	    		con = DriverManager.getConnection(url, user, pass);
	    	}
	    	catch (SQLException e) {
		        System.out.println(e.getMessage()); 
		    }
	        
	    }
	    catch (ClassNotFoundException ex) {
	        System.out.println(ex.getMessage()); 
	    }

		return con;
	    
	}		
	
}
