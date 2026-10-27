package ex_3;
import junit.framework.*;
public class TestWeatherRange extends TestCase{
	public void testWeatherRange() {
		//khoi tao Date
		Date d = new Date(12, 5, 2005);
		//khoi tao TemperatureRange
		TemperatureRange today = new TemperatureRange(28, 39);
		TemperatureRange normal = new TemperatureRange(25, 37);
		TemperatureRange record = new TemperatureRange(29, 34);
		//khoi tao WeatherRecord
		WeatherRecord wr = new WeatherRecord(d, today, normal, record, 200000);
		
		//withinRange
		assertFalse(wr.withinRange());
		//rainyDay
		assertTrue(wr.rainyDay(100000));
		//recordDay
		assertTrue(wr.recordDay());
	}
}
