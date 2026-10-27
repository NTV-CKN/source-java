package ex_3;
/**
 * trong TemperatureRange co 2 thuoc tinh:
 -int low
-int high
 */
public class TemperatureRange {
	 private int low;
	 private int high;
	 //constructor
	public TemperatureRange(int low, int high) {
		super();
		this.low = low;
		this.high = high;
	}
	//getter and setter
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	
}
