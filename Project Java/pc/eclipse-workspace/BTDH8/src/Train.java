/*
 * trong Train co 3 thuoc tinh:
 *	 - Schedule schedule

	- Route route

	- boolean local
	vidu:
	Train train = new Train(schedule, route, false);
 */
public class Train {
	private Schedule schedule;//lich
	private Route route;//lo trinh
	private boolean local;
	//constructor
	public Train(Schedule schedule, Route route, boolean local) {
		this.schedule = schedule;
		this.route = route;
		this.local = local;
	}
	
}
