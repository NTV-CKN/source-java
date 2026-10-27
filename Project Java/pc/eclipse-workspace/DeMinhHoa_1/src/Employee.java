import java.util.Objects;

public abstract class Employee {
protected int eid;
protected String name;
protected String address;
protected Date birthDay;
protected double salaryUnit;
protected double salaryRate;
@Override
public int hashCode() {
	return Objects.hash(address, birthDay, eid, name, salaryRate, salaryUnit);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	return Objects.equals(address, other.address) && Objects.equals(birthDay, other.birthDay) && eid == other.eid
			&& Objects.equals(name, other.name)
			&& Double.doubleToLongBits(salaryRate) == Double.doubleToLongBits(other.salaryRate)
			&& Double.doubleToLongBits(salaryUnit) == Double.doubleToLongBits(other.salaryUnit);
}
@Override
public String toString() {
	return "Employee [eid=" + eid + ", name=" + name + ", address=" + address + ", birthDay=" + birthDay
			+ ", salaryUnit=" + salaryUnit + ", salaryRate=" + salaryRate + "]";
}
public Employee(int eid, String name, String address, Date birthDay, double salaryUnit, double salaryRate) {
	super();
	this.eid = eid;
	this.name = name;
	this.address = address;
	this.birthDay = birthDay;
	this.salaryUnit = salaryUnit;
	this.salaryRate = salaryRate;
}
public abstract double salary();
public abstract int count();
public abstract  boolean isProduce(Produce that);
public abstract String getSaler(Produce that);

}
