
public class SaleStaff extends Employee{
private IItem rest;
	public SaleStaff(int eid, String name, String address, Date birthDay, double salaryUnit, double salaryRate, IItem ds) {
		super(eid, name, address, birthDay, salaryUnit, salaryRate);
this.rest = ds;
	}
	@Override
	public double salary() {
		return this.salaryRate*this.salaryUnit+9000000;
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 1;
	}
	@Override
	public boolean isProduct(Item that) {
		// TODO Auto-generated method stub
		return this.rest.checkProduct(that);
	}

}
