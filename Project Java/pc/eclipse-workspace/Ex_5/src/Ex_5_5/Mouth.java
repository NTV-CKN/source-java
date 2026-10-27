package Ex_5_5;
/**
 * trong Mouth co 1 thuoc tinh:
-Location location

vidu
Location lc6 = new Location(7, 5, "m");
Mouth mouth = new Mouth(lc6);

 */
public class Mouth {
	private Location location;//toa do
	//constructor
	public Mouth(Location location) {
		this.location = location;
	}
	//toString
	@Override
	public String toString() {
		return "Mouth: " + location.toString();
	}
	
}
