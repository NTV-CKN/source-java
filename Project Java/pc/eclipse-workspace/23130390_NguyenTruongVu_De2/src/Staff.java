
public class Staff extends Employee{
private String department;
	public Staff(int eid, String name, String address, Date birthDay, double salaryUnit, double salaryRate, String n) {
		super(eid, name, address, birthDay, salaryUnit, salaryRate);
this.department= n;
}
	@Override
	public double salary() {
		// TODO Auto-generated method stub
		return this.salaryRate*this.salaryUnit;
	}
	@Override
	public int count() {
		return 0;
	}
	@Override
	public boolean isProduct(Item that) {
		return false;
	}

}
