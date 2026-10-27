package ex_3;
/**
 * trong lop date co 3 thuoc tinh:
 -int day
-int month
-int year
 */
public class Date {
	private int day;
	private int month;
	private int year;
	//constructor
	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	//setter and getter
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}