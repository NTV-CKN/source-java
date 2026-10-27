package Ex_5_2;

import java.util.Objects;

/**
 * trong Date co 3 thuoc tinh:
-int day, month, year

vidu
		Date date1 = new Date(12, 12, 2005);
		Date date2 = new Date(9, 12, 2012);
		Date date3 = new Date(12, 11, 2024);
 */
public class Date {
	private int day, month, year;//nagy thang nam
	//constructor
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	//toString
	@Override
	public String toString() {
		return "Day: "+ day + ", Month: " + month + ", Year: " + year + "; ";
	}
	//equals
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
	
}
