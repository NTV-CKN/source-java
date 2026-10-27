/*
 * trong ClockTime gom 2 thuoc tinh:
 * int hour
 * int minute
 * vidu:
 * 	ClockTime departure = new ClockTime(2, 34);
		ClockTime arrival = new ClockTime(3, 34);
 */
public class ClockTime {
	private int hour;//gio
	private int minute;//phut
	//constructor
	public ClockTime(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
	}
}
