package ex_3;
/**
 * trong WeatherRecord co 5 thuoc tinh va 3 phuong thuc: 
 -Date d
-TemperatureRange today
-TemperatureRange normal
-TemperatureRange record
-double precipitation

+ boolean withinRange()=> tra ve KDL boolean, return true neu nhiet do cao va thap cua today nam trong pham vi nhiet do normal
	return this.today.getHigh() < this.normal.getHigh() && this.today.getLow() > this.normal.getLow();
	
+ boolean rainyDay(double that)=>tra ve KDL boolean,  return true neu luong mua cao hon 1 gia tri luong mua dua vao
	return this.precipitation > that;
	
+ boolean recordDay() =>tra ve KDL boolean, return true neu nhiet do cao cua today cao hon record hoac nhiet do thap cua today be hon nhiet do thap cua record
	return this.today.getHigh() > this.record.getHigh() || this.today.getLow() < this.record.getLow();
	
	vidu
	Date d = new Date(12, 5, 2005);
	
	TemperatureRange today = new TemperatureRange(28, 39);
	TemperatureRange normal = new TemperatureRange(25, 37);
	TemperatureRange record = new TemperatureRange(27, 34);
	
	WeatherRecord wr = new WeatherRecord(d, today, normal, record, 200000);
	
	
 */
public class WeatherRecord {
	 private Date d;
	 private TemperatureRange today;
	 private TemperatureRange normal;
	 private TemperatureRange record;
	 private double precipitation;
	 //constructor
	public WeatherRecord(Date d, TemperatureRange today, TemperatureRange normal, TemperatureRange record,
			double precipitation) {
		this.d = d;
		this.today = today;
		this.normal = normal;
		this.record = record;
		this.precipitation = precipitation;
	}
	//withinRange
	public boolean withinRange() {
		return this.today.getHigh() < this.normal.getHigh() && this.today.getLow() > this.normal.getLow();
	}
	 //rainyDay
	public boolean rainyDay(double that) {
		return this.precipitation > that;
	}
	//recordDay
	public boolean recordDay() {
		return this.today.getHigh() > this.record.getHigh() || this.today.getLow() < this.record.getLow();
	}
}
