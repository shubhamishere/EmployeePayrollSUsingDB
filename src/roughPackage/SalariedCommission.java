package roughPackage;

public class SalariedCommission {
	
	Salaried s = new Salaried();
	Commission c = new Commission();
	
	void getTotalSalary() {
		int salary = s.getWeeklySalary();
		int sales = c.getWeeklySale();
		
		System.out.println("Weekly salary is: " + s.getWeeklySalary());
		System.out.println("Weekly sales is: " + c.getWeeklySale());
		System.out.println("Total salary is: " + (salary + sales));
		
	}
}
