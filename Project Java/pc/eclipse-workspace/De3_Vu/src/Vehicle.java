
public class Vehicle {
private String name;
private int idd;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getIdd() {
	return idd;
}
public void setIdd(int idd) {
	this.idd = idd;
}
public Vehicle(String name, int idd) {
	super();
	this.name = name;
	this.idd = idd;
}
}
