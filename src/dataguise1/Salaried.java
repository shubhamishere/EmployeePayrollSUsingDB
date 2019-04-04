package dataguise1;

public class Salaried extends Employee{
	private int weeklySalary;
	
	Salaried(){
		
	}
	
	Salaried(int thisWeekSalary){
		weeklySalary = thisWeekSalary;
	}
	//set weekly salary.
	void setWeeklySalary(int thisWeekSalary) {
		weeklySalary = thisWeekSalary;
	}
	//get weekly salary.
	int getWeeklySalary() {
		return weeklySalary;
	}
	
	
}
