
public class Staff extends Employee{
private String department;
	public Staff(int eid, String name, String address, String birthDay, double salaryUnit, double salaryRate, String d) {
		super(eid, name, address, birthDay, salaryUnit, salaryRate);
		this.department = d;
	}

	@Override
	public double salary() {
		return this.salaryRate * this.salaryUnit;
	}

}
