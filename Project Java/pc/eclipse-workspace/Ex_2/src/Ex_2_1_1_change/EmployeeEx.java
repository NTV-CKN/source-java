package Ex_2_1_1_change;

import Ex_2_1_change.Employee;
/**
 * trong EmployeeEx ta ke thua lai Employee
 * va trong EmployeeEx se co them 2 phuong thuc:
 * double taxWithRate(double pricePerHour) => tra ve KDL double 
 * double netPayWithRate(double pricePerHour) => tra ve KDL double
 */
public class EmployeeEx extends Employee{

	public EmployeeEx(String name, int hours) {
		super(name, hours);
	}
	//taxWithRate
	double taxWithRate(double pricePerHour) {

		double grossPay = this.getWage(pricePerHour);

		if (grossPay <= 240)

		return 0.0;

		if (grossPay <= 480)

		return grossPay * 0.15;

		return grossPay * 0.28;

		}	
	//netPayWithRate
	double netpayWithRate(double pricePerHour) {

		return this.getWage(pricePerHour) - this.taxWithRate(pricePerHour);

		}
}
