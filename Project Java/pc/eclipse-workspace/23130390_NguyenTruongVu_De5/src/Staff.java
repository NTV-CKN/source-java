
public class Staff extends Employee{
public Staff(int eid, String name, String address, Date birthDay, double salaryUnit, double salaryRate, String de) {
		super(eid, name, address, birthDay, salaryUnit, salaryRate);
		// TODO Auto-generated constructor stub
		this.department = de;
	}

private String department;

@Override
public double salary() {
	// TODO Auto-generated method stub
	return this.salaryRate*this.salaryUnit;
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
