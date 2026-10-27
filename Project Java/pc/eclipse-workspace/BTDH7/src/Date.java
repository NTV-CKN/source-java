/*
 * trong Date co 3 thuoc tinh:
 * int day
 * int month 
 * int year
 * vidu:
 * Date d = new Date(12, 3, 2005);
 */
public class Date {
	private int day, month, year;//ngay, thang, nam
	//constructor
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}	
}
