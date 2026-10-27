import junit.framework.TestCase;
public class Test extends TestCase{
		//testDateConstructor
		public void testDateConstructor() {
		Date d = new Date(12, 3, 2005);
		}
		//testTemperatureRange
		public void testTemperatureRange() {
			TemperatureRange today = new TemperatureRange(2, 5);
			TemperatureRange normal = new TemperatureRange(2, 2);
			TemperatureRange record = new TemperatureRange(2, 1);
		}
		//testWeatherRecordConstructor
		public void testWeatherRecordConstructor() {
		//testDateConstructor
		new WeatherRecord(new Date(12, 3, 2005), new TemperatureRange(2, 5), new TemperatureRange(2, 2), new TemperatureRange(2, 1), 123);
	}
}
