
public class SaleStaff extends Employee{
public SaleStaff(int eid, String name, String address, Date birthDay, double salaryUnit, double salaryRate, IItem rest) {
		super(eid, name, address, birthDay, salaryUnit, salaryRate);
this.rest= rest;	}

private IItem rest;
	@Override
	public double salary() {
		// TODO Auto-generated method stub
		return this.salaryRate*this.salaryUnit+9000000;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public boolean isProduct(Product that) {
		return this.rest.checkProduct(that);
	}

}
