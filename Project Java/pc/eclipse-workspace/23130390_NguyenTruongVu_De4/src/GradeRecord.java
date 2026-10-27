
public class GradeRecord {
private int number;
private String tenMH;
private int credits;
private double grade;
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public String getTenMH() {
	return tenMH;
}
public void setTenMH(String tenMH) {
	this.tenMH = tenMH;
}
public int getCredits() {
	return credits;
}
public void setCredits(int credits) {
	this.credits = credits;
}
public double getGrade() {
	return grade;
}
public void setGrade(double grade) {
	this.grade = grade;
}
@Override
public String toString() {
	return "GradeRecord [number=" + number + ", tenMH=" + tenMH + ", credits=" + credits + ", grade=" + grade + "]";
}
public GradeRecord(int number, String tenMH, int credits, double grade) {
	super();
	this.number = number;
	this.tenMH = tenMH;
	this.credits = credits;
	this.grade = grade;
}
}
