/*
 * trong TimePoint cos 3 thuoc tinh private :
 * int seconds
 * int minutes
 * int hours
 * vidu:
 * new TimePoint(23, 23, 23);
 */
public class TimePoint {
	private int seconds;//giay
	private int minutes;//phut
	private int hours;//gio
	//constructor
	public TimePoint(int seconds, int minutes, int hours) {
		this.seconds = seconds;
		this.minutes = minutes;
		this.hours = hours;
	}
}
