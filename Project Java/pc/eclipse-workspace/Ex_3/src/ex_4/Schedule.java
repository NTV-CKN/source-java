package ex_4;
/**
 * trong Schedule co 2 thuoc tinh va 3 phuong thuc:
 - ClockTime departure
- ClockTime arrive

+String checkTimeDeparture()=> tra ve KDL String
	String str;
		return str = this.departure.getHour()  + ", " + this.departure.getMinute();
		
+String checkTimeArrive()=> tra ve KDL String

		String str;
		int countHour;
		int countMinute;
		if(this.departure.getHour() > this.arrive.getHour()) {
			countHour = (24 - this.departure.getHour()) + this.arrive.getHour();
			if(this.departure.getMinute() > this.arrive.getMinute()) {
				int setMinute = 60-this.departure.getMinute();
				countMinute = setMinute + this.arrive.getMinute();
			}else {
				countMinute = this.arrive.getMinute() - this.departure.getMinute();
			}
		}else {
			countHour = Math.abs(departure.getHour() - arrive.getHour());
			if(this.departure.getMinute() > this.arrive.getMinute()) {
				int setMinute = 60-this.departure.getMinute();
				countMinute = setMinute + this.arrive.getMinute();
			}else {
				countMinute = this.arrive.getMinute() - this.departure.getMinute();
			}
		}
		return str = countHour + ", "  + countMinute;

 */
public class Schedule {
	 private ClockTime departure;
	 private ClockTime arrive;
	 //constructor
	public Schedule(ClockTime departure, ClockTime arrive) {
		this.departure = departure;
		this.arrive = arrive;
	}
	//getter and setter
	public ClockTime getDeparture() {
		return departure;
	}
	public void setDeparture(ClockTime departure) {
		this.departure = departure;
	}
	public ClockTime getArrive() {
		return arrive;
	}
	public void setArrive(ClockTime arrive) {
		this.arrive = arrive;
	}

	//checkTimeDeparture
	public String checkTimeDeparture() {
		String str;
		return str = this.departure.getHour()  + ", " + this.departure.getMinute();
	}
	//checkTimeArrive
	public String checkTimeArrive() {
		String str;
		int countHour;
		int countMinute;
		if(this.departure.getHour() > this.arrive.getHour()) {
			countHour = (24 - this.departure.getHour()) + this.arrive.getHour();
			if(this.departure.getMinute() > this.arrive.getMinute()) {
				int setMinute = 60-this.departure.getMinute();
				countMinute = setMinute + this.arrive.getMinute();
			}else {
				countMinute = this.arrive.getMinute() - this.departure.getMinute();
			}
		}else {
			countHour = Math.abs(departure.getHour() - arrive.getHour());
			if(this.departure.getMinute() > this.arrive.getMinute()) {
				int setMinute = 60-this.departure.getMinute();
				countMinute = setMinute + this.arrive.getMinute();
			}else {
				countMinute = this.arrive.getMinute() - this.departure.getMinute();
			}
		}
		return str = countHour + ", "  + countMinute;
	}
}
