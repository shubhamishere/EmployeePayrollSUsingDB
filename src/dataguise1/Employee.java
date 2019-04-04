package dataguise1;

public abstract class Employee {
	private String firstName, lastName, employeeID, email;
	

	void setFirstName(String fname) {
		firstName = fname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	String getFirstName() {
		return firstName;
	}
	
	void setLastName(String lname) {
		lastName = lname;
	}

	String getLastName() {
		return lastName;
	}
	

	void setEmployeeId(String empId) {
		employeeID = empId;
	}

	String getEmployeeId() {
		return employeeID;
	}
}
