
public abstract class Employee {
protected String name, birthDay;

public Employee(String name, String birthDay) {
	super();
	this.name = name;
	this.birthDay = birthDay;
}

@Override
public String toString() {
	return "Employee [name=" + name + ", birthDay=" + birthDay + "]";
}


}
