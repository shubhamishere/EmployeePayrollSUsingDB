package dataguise1;
/*OUTPUT format of this code:-
 * 1.) Create entries of employees by selecting the type of employee (Total 4 types)
 *     a)-->first name, last name, email, employee ID [Common for all types]
 *     b)-->other fields depends upon the employee type selected during runtime.
 * 2.) Enter email id to search in employees
 * 3.) Enter the type of employee
 * 		If email match found
 * 			a) Calculate and display weekly salary/payout.
 * 		If email match not found
 * 			b) Display msg 'email not found'
 * 4.) Do you want to continue making employee entries?
 * 			a) if Yes, process execution goes to step 1
 * 			b) if No, program terminates with a Thank You note.
 * */

import java.util.Scanner;

import java.sql.*;

public class Payroll {
	
	public static void main(String[] args) throws SQLException {
		
		int searchFlag = 0;
		int input = 1;
		Scanner sc = new Scanner(System.in);
		
		EmployeeConnection connect = new EmployeeConnection();
		Connection con = connect.getConnection();
		
		while(input==1) {
			System.out.println("Select type of employee (select b/w 1-4 options ONLY!):\n1. Salaried\n2. Commission\n3. Salaried-commission\n4. Hourly");
			int choice = sc.nextInt();
			sc.nextLine();
			
			String empType;
			if(choice==1) {
				empType = "Salaried";
			}
			else if(choice==2) {
				empType = "Commission";
			}
			else if(choice==3) {
				empType = "Salaried-commission";
			}
			else if(choice==4) {
				empType = "Hourly";
			}
			else {
				System.out.println("Enter valid input! Try again.\n\n");
				continue;
			}
			
			System.out.print("Enter first name of " + empType + " employee: ");
			String fname = sc.nextLine();
			
			System.out.print("Enter last name of " + empType + " employee: ");
			String lname = sc.nextLine();
			
			System.out.print("Enter email id of " + empType + " employee: ");
			String email = sc.nextLine();
			
			System.out.print("Enter employee ID of " + empType + " employee: ");
			String id = sc.nextLine();
			
			switch(choice) {
				case 1:
					System.out.print("Enter this week salary: ");
					int salary = sc.nextInt();
					//Setting the inputs entered by the user.
					Salaried salariedEmp = new Salaried(salary);
					salariedEmp.setFirstName(fname);
					salariedEmp.setLastName(lname);
					salariedEmp.setEmail(email);
					salariedEmp.setEmployeeId(id);
					
				try {
					PreparedStatement pst = con.prepareStatement("insert into salaried values(?,?,?,?,?)");
					//Inserting values of salaried employees into the DB.
					pst.setString(1, salariedEmp.getFirstName());
					pst.setString(2, salariedEmp.getLastName());
					pst.setString(3, salariedEmp.getEmployeeId());
					pst.setInt(4, salariedEmp.getWeeklySalary());
					pst.setString(5, salariedEmp.getEmail());
					
					int status  = pst.executeUpdate();
					if(status==1) {
						System.out.println("Employee details added successfully to the database.");
					}
					else {
						System.out.println("Unable to add employee details to the database.");
					}
					
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
					
				case 2:
					System.out.print("Enter this week sale: ");
					int sale = sc.nextInt();
					//Setting the inputs entered by the user.
					Commission commissionEmp = new Commission(sale);
					commissionEmp.setFirstName(fname);
					commissionEmp.setLastName(lname);
					commissionEmp.setEmail(email);
					commissionEmp.setEmployeeId(id);
					
				try {
					PreparedStatement pst = con.prepareStatement("insert into commission values(?,?,?,?,?,?)");
					//Inserting values of commission employees into the DB.
					pst.setString(1, commissionEmp.getFirstName());
					pst.setString(2, commissionEmp.getLastName());
					pst.setString(3, commissionEmp.getEmployeeId());
					pst.setInt(4, commissionEmp.getWeeklySale());
					pst.setString(5, commissionEmp.getEmail());
					pst.setFloat(6, commissionEmp.getCommissonAmount());
					
					int status = pst.executeUpdate();
					if(status==1) {
						System.out.println("Employee details added successfully to the database.");
					}
					else {
						System.out.println("Unable to add employee details to the database.");
					}
					
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
					
				case 3:
					System.out.print("Enter this week salary: ");
					int salary2 = sc.nextInt();
					System.out.print("Enter this week sale: ");
					int sale2 = sc.nextInt();
					//Setting the inputs entered by the user.
					SalariedCommission salariedCommissionEmp = new SalariedCommission(salary2, sale2);
					salariedCommissionEmp.setFirstName(fname);
					salariedCommissionEmp.setLastName(lname);
					salariedCommissionEmp.setEmail(email);
					salariedCommissionEmp.setEmployeeId(id);

					try {
						PreparedStatement pst = con.prepareStatement("insert into salariedcommission values(?,?,?,?,?,?,?)");
						//Inserting values of salaied-commission employees into the DB.
						pst.setString(1, salariedCommissionEmp.getFirstName());
						pst.setString(2, salariedCommissionEmp.getLastName());
						pst.setString(3, salariedCommissionEmp.getEmployeeId());
						pst.setInt(4, salariedCommissionEmp.getWeeklySalary());
						pst.setInt(5, salariedCommissionEmp.getWeeklySales());
						pst.setString(6, salariedCommissionEmp.getEmail());
						pst.setFloat(7, salariedCommissionEmp.getCommissonAmount());
						
						int status = pst.executeUpdate();
						if(status==1) {
							System.out.println("Employee details added successfully to the database.");
						}
						else {
							System.out.println("Unable to add employee details to the database.");
						}
						
					}
					catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
					
				case 4:
					System.out.print("Enter hours worked: ");
					int hoursWorked = sc.nextInt();
					
					Hourly hourlyEmp = new Hourly(hoursWorked);
					hourlyEmp.setFirstName(fname);
					hourlyEmp.setLastName(lname);
					hourlyEmp.setEmail(email);
					hourlyEmp.setEmployeeId(id);
					
					try {
						PreparedStatement pst = con.prepareStatement("insert into hourly values(?,?,?,?,?,?)");
						//Inserting values of hourly employees into the DB.
						pst.setString(1, hourlyEmp.getFirstName());
						pst.setString(2, hourlyEmp.getLastName());
						pst.setString(3, hourlyEmp.getEmployeeId());
						pst.setFloat(4, hourlyEmp.getWorkedHours());
						pst.setFloat(5, hourlyEmp.getPayment());
						pst.setString(6, hourlyEmp.getEmail());
						
						int status = pst.executeUpdate();
						if(status==1) {
							System.out.println("Employee details added successfully to the database.");
						}
						else {
							System.out.println("Unable to add employee details to the database.");
						}
						
					}
					catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					break;
					
			}
			sc.nextLine();
			System.out.println("----------------------------");
			//-------- [2] ---------
			System.out.println("Enter an email ID to search in employees record: ");
			String searchEmail = sc.nextLine();
			
			//-------- [3] ---------
			System.out.println("Enter employee type to search in (enter b/w 1-4 ONLY):\n1. Salaried\n2. Commission\n3. Salaried-commission\n4. Hourly ");
			int typeOfEmployee = sc.nextInt();
			
			if(typeOfEmployee==1) {
				PreparedStatement pst = con.prepareStatement("select * from salaried where email=?");
				pst.setString(1, searchEmail);
				ResultSet rs = pst.executeQuery();
				//Retrieve and sout the values of salaried employees from the DB.
				while(rs.next()) {
					String emailRetrived = rs.getString("email");
					if(emailRetrived.equalsIgnoreCase(searchEmail)) {
						searchFlag = 1;
						System.out.println("EMAIL MATCH FOUND!!");
						System.out.println("Email id: " + rs.getString(5));
						System.out.print("Full name: " + rs.getString(1) + " ");
						System.out.println(rs.getString(2));
						System.out.println("Employee id: " + rs.getString(3));
						System.out.println("Weekly salary: " + rs.getInt(4));
					}
				}
				System.out.println("___________________");
				
			}
			
			else if(typeOfEmployee==2) {
				//--------- [3].a ----------
				PreparedStatement pst = con.prepareStatement("select * from commission where email=?");
				pst.setString(1, searchEmail);
				ResultSet rs = pst.executeQuery();
				//Retrieve and sout the values of commission employees from the DB.
				while(rs.next()) {
					String emailRetrived = rs.getString("email");
					if(emailRetrived.equalsIgnoreCase(searchEmail)) {
						searchFlag = 1;
						System.out.println("EMAIL MATCH FOUND!!");
						System.out.println("Email id: " + rs.getString(5));
						System.out.print("Full name: " + rs.getString(1) + " ");
						System.out.println(rs.getString(2));
						System.out.println("Employee id: " + rs.getString(3));
						System.out.println("Weekly sale: " + rs.getInt(4));
						System.out.println("Commission amount: " + rs.getFloat(6));
					}
				}
				System.out.println("___________________");
				
			}
			
			else if(typeOfEmployee==3) {
				//--------- [3].a ----------
				PreparedStatement pst = con.prepareStatement("select * from salariedCommission where email=?");
				pst.setString(1, searchEmail);
				ResultSet rs = pst.executeQuery();
				//Retrieve and sout the values of salaried-commission employees from the DB.
				while(rs.next()) {
					String emailRetrived = rs.getString("email");
					if(emailRetrived.equalsIgnoreCase(searchEmail)) {
						searchFlag = 1;
						System.out.println("EMAIL MATCH FOUND!!");
						System.out.println("Email id: " + rs.getString(6));
						System.out.print("Full name: " + rs.getString(1) + " ");
						System.out.println(rs.getString(2));
						System.out.println("Employee id: " + rs.getString(3));
						System.out.println("Weekly salary: " + rs.getInt(4));
						System.out.println("Weekly sale: " + rs.getInt(5));
						System.out.println("Total payble salary: " + rs.getFloat(7));
					}
				}
				System.out.println("___________________");
				
			}
			
			else if(typeOfEmployee==4) {
				//--------- [3].a ----------
				PreparedStatement pst = con.prepareStatement("select * from hourly where email=?");
				pst.setString(1, searchEmail);
				ResultSet rs = pst.executeQuery();
				//Retrieve and sout the values of hourly employees from the DB.
				while(rs.next()) {
					String emailRetrived = rs.getString("email");
					if(emailRetrived.equalsIgnoreCase(searchEmail)) {
						searchFlag = 1;
						System.out.println("EMAIL MATCH FOUND!!");
						System.out.println("Email id: " + rs.getString(6));
						System.out.print("Full name: " + rs.getString(1) + " ");
						System.out.println(rs.getString(2));
						System.out.println("Employee id: " + rs.getString(3));
						System.out.println("Worked hours: " + rs.getInt(4));
						System.out.println("Payment: " + rs.getInt(5));
					}	
				}
				System.out.println("___________________");
				
			}
			
			else {
				System.out.println("Invalid input!");
				System.exit(0);
			}
			//--------- [3].b ----------
			if(searchFlag==0) {
				System.out.println("Employee not found with your email query: " + "'" + searchEmail + "'");
			}
			
			//--------- [4] ----------
			if(input==1) {
				System.out.println("-----------------------------");
				System.out.println("Do you want to continue?\n1. Yes\n2. No");
				int choice2 = sc.nextInt();
				//--------- [4].a ----------
				if(choice2==1) {
					input = 1;
				}
				//--------- [4].b ----------
				else if(choice2==2) {
					System.out.println("Thank you");
					input = 0;
				}
				else {
					System.out.println("Wrong input.");
					System.exit(0);
				}
				
			}
		}
		
	}

}
