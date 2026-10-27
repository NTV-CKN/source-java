
public class SaleStaff extends Employee{
	private DanhSachProduct danhSach;
public SaleStaff(int eid, String name, String address, String birthDay, double salaryUnit, double salaryRate, DanhSachProduct danhSach) {
		super(eid, name, address, birthDay, salaryUnit, salaryRate);
		this.danhSach = danhSach;
 CountEmployee.count();
	}



public DanhSachProduct getDanhSach() {
	return danhSach;
}



public void setDanhSach(DanhSachProduct danhSach) {
	this.danhSach = danhSach;
}



@Override
public double salary() {
	return this.salaryRate * this.salaryUnit + 9000000;
}
//isProduct
public boolean isProduct(Product that) {
	return this.danhSach.checkProduct(that);
}
//getSalers
public void getSaler(Product that) {
	
	String str;
	if(this.danhSach.checkProduct(that) == true){
		str = this.toString();
	}else {
		str = "";
	}
	System.out.println(str);
}
}
