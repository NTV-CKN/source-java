
public class SaleStaff extends Employee{
private IProduct rest;
	public SaleStaff(int eid, String name, String address, Date birthDay, double salaryUnit, double salaryRate, IProduct e) {
		super(eid, name, address, birthDay, salaryUnit, salaryRate);
		// TODO Auto-generated constructor stub
		this.rest = e;
	}
	@Override
	public double salary() {
		// TODO Auto-generated method stub
		return this.salaryRate*this.salaryUnit + 9000000;
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 1;
	}
	@Override
	public boolean isProduct(Product that) {
		// TODO Auto-generated method stub
		return this.rest.checkProduct(that);
	}

}
