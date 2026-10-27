package Ex_6_6;

import java.util.Objects;

/**
 * trong Date co 3 thuoc tinh va 1 phuong thuc so sanh Date:
-int month, day, year

+boolean sS(Date that)
 */
public class Date {
	private int day, month, year;//ngay thang nam
	//constructor
	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	//sS(Date that)
	public boolean sS(Date that) {
		boolean boo = false;
		if(this.year<that.year) {
			boo = true;
		}else if(this.month < that.month && this.year == that.year) {
			boo = true;
	}else if(this.day<=that.day && this.month == that.month && this.year == that.year) {
		boo = true;
	}
		return boo;
	}
	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
	}

	
}
