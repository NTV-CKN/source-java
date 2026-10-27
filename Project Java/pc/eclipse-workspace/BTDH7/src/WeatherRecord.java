/*
 * trong WeatherRecord co 5 thuoc tinh:
 * -Date d

-TemperatureRange today

-TemperatureRange normal

-TemperatureRange record

-double precipitation
 vidu:
 	new WeatherRecord(new Date(12, 3, 2005), new TemperatureRange(2, 5), new TemperatureRange(2, 2), new TemperatureRange(2, 1), 123);

 */
public class WeatherRecord {
	private Date d;//lop Date
	private TemperatureRange today;//pham vi nhiet do hom nay
	private TemperatureRange normal;//pham vi nhiet do thuong
	private TemperatureRange record;//pham vi nhiet do ghi nhan
	private double precipitation;//mua
	//constructor
	public WeatherRecord(Date d, TemperatureRange today, TemperatureRange normal, TemperatureRange record,
			double precipitation) {
		this.d = d;
		this.today = today;
		this.normal = normal;
		this.record = record;
		this.precipitation = precipitation;
	}
}
