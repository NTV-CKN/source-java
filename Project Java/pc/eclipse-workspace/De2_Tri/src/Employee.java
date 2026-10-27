
public abstract class Employee {
	protected int eid;
	protected String name;
	protected String address;
	protected String birthDay;
	protected double salaryUnit;
	protected double salaryRate;
	private SaleStaff sale;
	public Employee(int eid, String name, String address, String birthDay, double salaryUnit, double salaryRate) {
		this.eid = eid;
		this.name = name;
		this.address = address;
		this.birthDay = birthDay;
		this.salaryUnit = salaryUnit;
		this.salaryRate = salaryRate;
	}
	//getter setter
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public double getSalaryUnit() {
		return salaryUnit;
	}
	public void setSalaryUnit(double salaryUnit) {
		this.salaryUnit = salaryUnit;
	}
	public double getSalaryRate() {
		return salaryRate;
	}
	public void setSalaryRate(double salaryRate) {
		this.salaryRate = salaryRate;
	}
	//salary
	public abstract double salary();
	//count
	public int countEmployeeSaleStaff() {
		return CountEmployee.count;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", address=" + address + ", birthDay=" + birthDay
				+ ", salaryUnit=" + salaryUnit + ", salaryRate=" + salaryRate + "]";
	}
	public void goi(Product that, Employee that2) {
		if(that2 instanceof SaleStaff) {
			((SaleStaff)that2).getSaler(that);;
		//	this.sale.setDanhSach(this.sale.getDanhSach());
	
		}else {
			System.out.println("");
		}
		
}
}
