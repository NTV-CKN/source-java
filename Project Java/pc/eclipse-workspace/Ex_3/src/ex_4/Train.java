package ex_4;
/**
 * trong Train co 3 thuoc tinh va 3 phuong thuc:
- Schedule schedule
- Route route
- boolean local

+boolean checkDestination(String that)=> tra ve KDL boolean, return true neu diem den cua tau trung voi diem den cua tham so dau vao
	return this.route.getDestination().equals(that);
	
+String checkTrainStart ()=> tra ve KDL String
	return this.schedule.checkTimeDeparture();

+String checkArriveTrain()=> tra ve KDL String, return ve so gio tau di duoc
	return this.schedule.soGioTauDen();
	
	vidu:
	ClockTime departure = new ClockTime(12, 20);
	ClockTime arrive = new ClockTime(14, 50);
	
	Schedule schedule = new Schedule(departure, arrive);
	
	Route route = new Route("Quan 1", "Quan 9");
	
	Train train = new Train(schedule, route, true);
	
		//checkDestination
		assertEquals(true, train.checkDestination("Quan 9"));
		//checkTrainStart
		assertEquals(12, train.checkTrainStart());
		//checkTrainArrive
		assertEquals(14, train.checkTrainArrive());
 */
public class Train {
	private Schedule schedule;
	private Route route;
	private boolean local;
	//constructor
	public Train(Schedule schedule, Route route, boolean local) {
		this.schedule = schedule;
		this.route = route;
		this.local = local;
	}
	//checkDestination
	public boolean  checkDestination(String that) {
		return this.route.getDestination().equals(that);
	}
	//checkTrainStart
	public String checkTrainStart() {
		return this.schedule.checkTimeDeparture();
	}
	//checkTrainArrive
	public String checkTrainArrive() {
		return this.schedule.checkTimeArrive();
	}
}
