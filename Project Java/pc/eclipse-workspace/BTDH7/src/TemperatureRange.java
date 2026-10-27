/*
 * trong TemperatureRange co 2 thuoc tinh:
     *int low
     *int high
     *vidu
     *	TemperatureRange today = new TemperatureRange(2, 5);
		TemperatureRange normal = new TemperatureRange(2, 2);
		TemperatureRange record = new TemperatureRange(2, 1);
 */
public class TemperatureRange {
	private int low;//thap
	private int high;//cao
	//constructor
	public TemperatureRange(int low, int high) {
		this.low = low;
		this.high = high;
	}
	
}
