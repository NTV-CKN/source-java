package Ex_3;
/**
 * trong Subway co 2 thuoc tinh:
-double lengthOfSubway
-double kilometerPerHour
*lop nay duoc ke thua 2 thuoc tinh brand va model tu Verhicles
 */
public class Subway extends Verhicles{
	private double lengthOfSubway;//chieu dai tau dien ngam 
	private double kilometerPerHour;//so km tren gio
	//constructor
	public Subway(String model, String brand, double lengthOfSubway, double kilometerPerHour) {
		super(model, brand);
		this.lengthOfSubway = lengthOfSubway;
		this.kilometerPerHour = kilometerPerHour;
	}
	//getter and setter
	public double getLengthOfSubway() {
		return lengthOfSubway;
	}
	public void setLengthOfSubway(double lengthOfSubway) {
		this.lengthOfSubway = lengthOfSubway;
	}
	public double getKilometerPerHour() {
		return kilometerPerHour;
	}
	public void setKilometerPerHour(double kilometerPerHour) {
		this.kilometerPerHour = kilometerPerHour;
	}
	/**
	 *toString()
		 vidu 		assertEquals(sw.toString(), "#hdf, AK, 5.3, 100.0");
	 *tra co dangsuper.toString() + this.getLengthOfSubway()+", "+this.getKilometerPerHour(); tra ve ket qua la "#hdf, AK, 5.3, 100.0"
	 */		@Override
	public String toString() {
		return super.toString() + this.getLengthOfSubway()+", "+this.getKilometerPerHour();
	}
	
}
