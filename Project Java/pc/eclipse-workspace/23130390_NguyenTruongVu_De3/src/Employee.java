
public abstract class Employee {
protected int eid;
protected String name, address;
protected Date birthDay;
protected double salaryUnit, salaryRate;
public Employee(int eid, String name, String address, Date birthDay, double salaryUnit, double salaryRate) {
	super();
	this.eid = eid;
	this.name = name;
	this.address = address;
	this.birthDay = birthDay;
	this.salaryUnit = salaryUnit;
	this.salaryRate = salaryRate;
}
@Override
public String toString() {
	return "Employee [eid=" + eid + ", name=" + name + ", address=" + address + ", birthDay=" + birthDay
			+ ", salaryUnit=" + salaryUnit + ", salaryRate=" + salaryRate + "]";
}
//salary
public abstract double salary();
//Count
public abstract int count();
//isProduct
public abstract boolean isProduct(Product that);
}
