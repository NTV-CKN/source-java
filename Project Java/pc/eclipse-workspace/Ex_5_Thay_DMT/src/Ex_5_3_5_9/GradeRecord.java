package Ex_5_3_5_9;
/**
 * trong GradeRecord co 4 thuoc tinh:
-int number
-String title
-int credits
-double grade

vidu
		GradeRecord gr1 = new GradeRecord(23199, "Java Core", 3, 5);
		GradeRecord gr2 = new GradeRecord(23199, "Database", 2, 7);
		GradeRecord gr3 = new GradeRecord(23199, "Java Swing", 3, 2);

 */
public class GradeRecord {
	private int number;//ma mon hoc
	private String title;//ten mon hoc
	private int credits;//so tin chi
	private double grade;//diem
	//constructor
	public GradeRecord(int number, String title, int credits, double grade) {
		super();
		this.number = number;
		this.title = title;
		this.credits = credits;
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "GradeRecord [number=" + number + ", title=" + title + ", credits=" + credits + ", grade=" + grade + "]";
	}
	//countCredit
	public int countCredit() {
		return this.credits;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	//
	public boolean checkGrade(GradeRecord that) {
		return this.grade >= that.grade;
	}
}
