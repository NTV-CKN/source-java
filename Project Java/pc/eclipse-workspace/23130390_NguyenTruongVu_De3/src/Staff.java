
public class Staff extends Employee{
public Staff(int eid, String name, String address, Date birthDay, double salaryUnit, double salaryRate, String d) {
		super(eid, name, address, birthDay, salaryUnit, salaryRate);
this.department= d;	}

private String department;
	@Override
	public double salary() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isProduct(Product that) {
		// TODO Auto-generated method stub
		return false;
	}

}
