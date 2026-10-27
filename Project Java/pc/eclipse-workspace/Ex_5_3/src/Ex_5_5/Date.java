package Ex_5_5;

import java.util.Objects;

/**
 * trong Date co 3 thuoc tinh va 1 phuong thuc:
-int day
-int month
-int year

+boolean sameMonthInAYear(int month, int year)
	=> return true neu tham so dau vao year bang this.year va month bang this.month, false nguoc lai
	
 */
public class Date {
	private int day;//ngay
	private int month;//thang
	private int year;//nam
	//constructor
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		return day == other.day && month == other.month && year == other.year;
	}
	//sameMonthInAYear(int month, int year)
	public boolean sameMonthInAYear(int month, int year) {
		boolean boo = false;
		if(this.year ==year && this.month == month) {
			boo= true;
		}else {
			boo = false;
		}
		return boo;
	}
}
