
public class Driver extends Employee{
public Driver(String name, String birthDay, DanhSach ds) {
		super(name, birthDay);
this.ds = ds;
}

private DanhSach ds;
public String getDrivers(Vehicle v) {
	String str;
	if(this.ds.isDriver(v)== true) {
		str = super.toString();
	}else {
		str="";
	}
	return str;
}



}
