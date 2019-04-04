package dataguise1;

public class SalariedCommission extends Employee{
	int weeklySalary, weeklySales;
	Salaried salary = new Salaried();
	Commission commission = new Commission();
	
	SalariedCommission(int thisWeekSalary, int thisWeekSale) {
		salary.setWeeklySalary(thisWeekSalary);
		commission.setWeeklySales(thisWeekSale);
	}
	
	
	int getWeeklySalary() {
		weeklySalary = salary.getWeeklySalary();
		return weeklySalary;
	}
	
	int getWeeklySales() {
		weeklySales = commission.getWeeklySale();
		return weeklySales;
	}
	
	void setIncrementInWeeklySalary(int increasePercent) {
		double percentIncrease = (double)increasePercent;
		double part = (percentIncrease/100)*weeklySalary;
		weeklySalary = (int) (weeklySalary + part);
	}
	
	float getCommissonAmount() {
		//commission amount = 15% of weekly sales.
		float commissionPercent = 15;
		return (commissionPercent/100)*weeklySales;
	}
	double getTotalSalary() {
		double salesAmount = getCommissonAmount();
		float salaryAmount = weeklySalary;
		return salesAmount + salaryAmount;
	}
}
