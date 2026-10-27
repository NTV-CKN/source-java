package Ex_5_2;

import java.util.Objects;

/**
 * trong Entry co 4 thuoc tinh:
-Date date 
-double distance
-int duration
-String comment

vidu
	Entry entry1 = new Entry(date1, 12.2, 12, "Bad");
		Entry entry2 = new Entry(date2, 22.2, 21, "Good");
		Entry entry3 = new Entry(date3, 5.0, 3, "Normal");
 */
public class Entry {
	private Date date ;//ngay thang nam
	private double distance;//khoang cach chay
	private int duration;//thoi gian chay
	private String comment;//nhan xet
	//constructor
	public Entry(Date date, double distance, int duration, String comment) {
		this.date = date;
		this.distance = distance;
		this.duration = duration;
		this.comment = comment;
	}
	//toString
	@Override
	public String toString() {
		return "Date: " + date + "; distance: " + distance + "; duration: " + duration + "; comment: " + comment;
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
		Entry other = (Entry) obj;
		return Objects.equals(comment, other.comment) && Objects.equals(date, other.date)
				&& Double.doubleToLongBits(distance) == Double.doubleToLongBits(other.distance)
				&& duration == other.duration;
	}
	
}
