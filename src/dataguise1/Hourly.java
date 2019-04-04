package dataguise1;

public class Hourly extends Employee{
	private float workedHours, payment, overtimeHours;
	private float ratePerHour = 250;
	private float overtimeRatePerHour = (float)(250 * 1.5);
	
	Hourly(float hoursWorked){
		workedHours = hoursWorked;
	}
	
	void setWorkedHours(float hoursWorked) {
		workedHours = hoursWorked;
	}
	float getWorkedHours() {
		return workedHours;
	}
	float getPayment() {
		
		if(workedHours <= 0) {
			System.out.println("Invalid entry!");
		}
		else if(workedHours > 40) {
			overtimeHours = workedHours - 40;
			//OVERTIME PAYMENT = (PAYMENT OF INITIAL 40 HOURS) + (PAYMENT OF EXTRA HOURS) X (RATE PER HOUR X 1.5).
			payment = (float)((40 * ratePerHour) + (overtimeHours * overtimeRatePerHour));
		}
		else {
			payment = ratePerHour * workedHours;
		}
		return payment;
	}
	
}
