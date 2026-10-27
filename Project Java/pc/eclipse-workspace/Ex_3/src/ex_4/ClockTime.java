package ex_4;
/**
 * trong class ClockTime co 2 thuoc tinh va 1 phuong thuc tinh so gio tau den noi:
 - int hour
- int minute
 */
public class ClockTime {
	private int hour;
	private int minute;
	//constructor
	public ClockTime(int hour, int minute) {
if(this.hour <= 24 && this.hour>= 0 && this.minute>=0 && this.minute<= 59) {
		this.hour = hour;
		this.minute = minute;
		}else {
			this.hour = 1;
			this.minute = 1;
		}
		
	}
	//setter and getter
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
}
