/*
 * trong Schedule co 2 thuoc tinh;
 * - ClockTime departure
	- ClockTime arrival
	vidu:
	Schedule schedule = new Schedule(departure, arrival);
 */
public class Schedule {
	private ClockTime departure;//thoi gian khoi hanh 
	private ClockTime arrival;//thoi gian den
	//constructor
	public Schedule(ClockTime departure, ClockTime arrival) {
		this.departure = departure;
		this.arrival = arrival;
	}
	
}
