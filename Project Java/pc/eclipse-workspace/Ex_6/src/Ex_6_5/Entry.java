package Ex_6_5;

import java.util.Objects;

/**
 * trong Entry co 4 thuoc tinh va 2 phuong thuc:
-Date date
-double distance
-int duration
+String comment
+double speedPerMinute

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
	public double speedPerMinute;//toc do moi phut
	//constructor
	public Entry(Date date, double distance, int duration, String comment, double speed) {
		this.date = date;
		this.distance = distance;
		this.duration = duration;
		this.comment = comment;
		this.speedPerMinute = speed;
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
		return Double.doubleToLongBits(speedPerMinute) >= Double.doubleToLongBits(other.speedPerMinute);
	}






	@Override
	public String toString() {
		return "Entry [date=" + date + ", distance=" + distance + ", duration=" + duration + ", comment=" + comment
				+ ", speedPerMinute=" + speedPerMinute + "]";
	}

	//equalsSpeedPerMinute
	public boolean equalsSpeedPerMinute(Entry that) {
		return this.speedPerMinute >= that.speedPerMinute;
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
