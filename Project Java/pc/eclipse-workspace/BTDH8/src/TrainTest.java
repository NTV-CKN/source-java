
import junit.framework.TestCase;
public class TrainTest extends TestCase{
	public void testConstructor() {
		//khoi tao ClockTime
		ClockTime departure = new ClockTime(2, 34);
		ClockTime arrival = new ClockTime(3, 34);
		//khoi tao Route
		Route route = new Route("Quan 1", "Quan 7");
		//khoi tao Schedule
		Schedule schedule = new Schedule(departure, arrival);
		//khoi tao Train
		Train train = new Train(schedule, route, false);
	}
}
