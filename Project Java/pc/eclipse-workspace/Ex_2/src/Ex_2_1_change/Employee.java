package Ex_2_1_change;
/**
 * trong class Employee có 2 thuôc tính:
 * String name;
 * int hours
 * vidu:
 * new Employee("Nguyen Truong Vu", 12);
 * new Employee("Nguyen Tuong Vy", 23);
 */
public class Employee {
	private String name;//tên 
	private int hours;//so gio
	
	//constructor
	public Employee(String name, int hours) {
		this.name = name;
		this.hours = hours;
	}
	/**
	 * Employee e = new Employee("Nguyen Truong Vu", 12)
	 * trong e co 4 methods:
	 *1  double getWage(double pricePerHour) => tra ve KDL la double va nhan tham so dau vao co KDL la double, return this.hours * pricePerHour;
	 * 	vidu: e.getWage(12);
	 * 	=> 12 * 12
	 * 2 double tax(double taxRate, double pricePerHour) => tra ve KDL la double, return e.getWage(12) * taxRate;
	 * 	vidu: e.tax(0.15, 12);
	 * 	=> 144 * 0.15
	 * 3 double netPay() => tra ve KDL la double, return e.getWage(double pricePerHour) - e.tax(double taxRate, double pricePerHour);
	 * vidu: e.netPay(double taxRate, double pricePerHour);
	 *  	=> 144 - 21.6
	 *  4 double raisedWage(double pricePerHour) => tra ve KDL la double, return e.wage(double pricePerHour) + 14;
	 *  vidu: e.raisedWage(12);
	 *  	=> 144 + 14
	 *  5 boolean checkOverTime() => tra ve KDL True/False
	 *  vidu: e.checkOverTime();
	 *  	=> True
	 */
	//wage()
	public double getWage(double pricePerHour) {
		return this.hours * pricePerHour;
	}
	//tax()
	public double tax(double taxRate, double pricePerHour ) {
		return this.getWage(pricePerHour) * taxRate;
	}
	//netPay
	public double netPay(double taxRate, double pricePerHour) {
		return this.getWage(pricePerHour) - this.tax(taxRate, pricePerHour);
	}
	//raisedWage()
	public double raisedWage(double pricePerHour) {
		return this.getWage(pricePerHour) +14;
	}
	//checkOverTime()
	public boolean checkOverTime() {
		return this.hours *7 < 100;
	}
}
