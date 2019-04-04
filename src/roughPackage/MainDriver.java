package roughPackage;

public class MainDriver {
	public static void main(String ar[]) {
		SalariedCommission emp1 = new SalariedCommission();
		emp1.s.setWeeklySalary(5);
		emp1.c.setWeeklySales(12);
		
		emp1.getTotalSalary();
		System.out.println();
		
		
	}
}
