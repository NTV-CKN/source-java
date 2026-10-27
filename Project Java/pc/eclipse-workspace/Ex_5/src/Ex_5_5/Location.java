package Ex_5_5;
/**
 * trong Location co 3 thuoc tinh:
-int x
-int y
-String name

vidu
		Location lc1 = new Location(1, 1, "s");
		Location lc2 = new Location(1, 5, "t");
		Location lc3 = new Location(3, 7, "u");
		Location lc4 = new Location(3, 3, "b");
		Location lc5 = new Location(5, 5, "a");/
		Location lc6 = new Location(7, 5, "m");
 */
public class Location {
	private int x,y;//toa do x y 
	private String name;//ten
	//constructor
	public Location(int x, int y, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
	}
	//toString
	@Override
	public String toString() {
		return "Location: x= " + x + ", y= " + y + ", name: " + name+".";
	}
	
}
