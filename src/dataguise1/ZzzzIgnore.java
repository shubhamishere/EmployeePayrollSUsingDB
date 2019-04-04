package dataguise1;

import java.sql.*;

public class ZzzzIgnore{
		
	public static void main(String ar[]) throws SQLException {
		EmployeeConnection connect = new EmployeeConnection();
		Connection con = connect.getConnection();
		
		Statement st = con.createStatement();
        int status = st.executeUpdate("insert into commission(id, email) value(1, 'Shubham.commission@gmail.com')");
        if(status==1) {
        	System.out.println("Inserted successfully!!");
        }
        else {
        	System.out.println("Insertion failure!");
        }
		
	}
	
}
