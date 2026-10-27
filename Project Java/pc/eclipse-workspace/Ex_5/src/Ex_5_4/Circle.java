package Ex_5_4;
/**
 * trong Circle co 1 thuoc tinh:
-int radius

 */
public class Circle extends ASingleShape{
	private int radius;//ban kinh
	//constructor
	public Circle(CartPt location, int radius) {
		super(location);
		this.radius = radius;
	}
	//toString
	@Override
	public String toString() {
		return "Circle: Radius: "+ radius + this.location.toString();
	}
	
}
