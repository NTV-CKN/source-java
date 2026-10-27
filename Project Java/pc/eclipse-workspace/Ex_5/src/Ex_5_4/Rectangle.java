package Ex_5_4;
/**
 * trong Rectangle co 2 thuoc tinh:
-int width
-int height

 */
public class Rectangle extends ASingleShape{
	private int width, height;//chieu rong chieu dai
	//constructor
	public Rectangle(CartPt location, int width, int height) {
		super(location);
		this.width = width;
		this.height = height;
	}
	//toString
	@Override
	public String toString() {
		return "Rectangle: width: " + width + ", height: " + height + this.location.toString();
	}
	
}
