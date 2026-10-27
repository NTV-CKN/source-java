package Ex_5_5;

import java.util.Objects;

/**
 * trong Entry co 4 thuoc tinh va 2 phuong thuc:
-Date date
-double distance
-int duration
+String comment

+double getDistance()
	=>return this.distance;
+boolean sameMonthInAYear(int month, int year)
	=>return date.sameMonthInAYear(month, year);
 */
public class Entry {


	private Date date;//ngay thang nam
	private double distance;//khoang cach
	private int duration;//khoang thoi gian
	public String comment;//binh luan
	//constructor
	public Entry(Date date, double distance, int duration, String comment) {
		this.date = date;
		this.distance = distance;
		this.duration = duration;
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Entry [date=" + date + ", distance=" + distance + ", duration=" + duration + ", comment=" + comment
				+ "]";
	}

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
	//getDistance()
		public double getDistance() {
		return distance;
	}
	//sameMonthInAYear(int month, int year)
		public boolean sameMonthInAYear(int month, int year) {
			return this.date.sameMonthInAYear(month, year);
		}
}
