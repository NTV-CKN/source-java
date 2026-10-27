package ex_4;
import junit.framework.*;
public class Test extends TestCase{
	public void testTrain() {
		ClockTime departure = new ClockTime(23, 40);
		ClockTime arrive = new ClockTime(1, 20);
		
		Schedule schedule = new Schedule(departure, arrive);
		
		Route route = new Route("Quan 1", "Quan 9");
		
		Train train = new Train(schedule, route, true);
		
		//checkDestination
		assertEquals(true, train.checkDestination("Quan 9"));
		//checkTrainStart
		assertEquals("23, 40", train.checkTrainStart());
		//soGioTauDen
		assertEquals("2, 40", train.checkTrainArrive());
	}
}
