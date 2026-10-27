
public class SaleStaff extends Employee{
public SaleStaff(int eid, String name, String address, Date birthDay, double salaryUnit, double salaryRate, ListProduce s) {
		super(eid, name, address, birthDay, salaryUnit, salaryRate);
		this.ds = s;
	}



private ListProduce ds;

@Override
public double salary() {
	return salaryRate * salaryUnit + 90000000;
}

@Override
public int count() {
	return 1;
}

@Override
public boolean isProduce(Produce that) {
	return ds.checkProduce(that);
}

@Override
public String getSaler(Produce that) {
	String str="";
	if(this.ds.checkProduce(that)) {
		str = this.toString();
	}
	return this.ds;
}
}
