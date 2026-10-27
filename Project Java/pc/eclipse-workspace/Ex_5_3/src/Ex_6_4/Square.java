package Ex_6_4;
/**
 * trong Square co 1 thuoc tinh:
-int size

 */
public class Square extends ASingleShape{
	private int size;//kich thuoc canh hinh vuong
	//constructor
	public Square(CartPt location, int size) {
		super(location);
		this.size = size;
	}
	//toString
	@Override
	public String toString() {
		return "Square: "+ "Size: " + size + this.location.toString();
	}
	@Override
	public BoundingBox getBoundingBox() {
		return new BoundingBox(location.getX(), location.getY(), size+location.getX() , size+location.getY());
	}
	
}
