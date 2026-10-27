package Ex_4;
/**
  * trong Square co 1 thuoc tinh va 4 phuong thuc tu IsShape, 1 thuoc tinh ke thua tu AShape:
+area()
+boolean contains(CartPt point)
+Rectangle boundingBox()
+double perimeter()

-int size
 */
public class Square extends AShape{
	private int size;// kich thuoc cua canh
	//constructor
	public Square(CartPt cartPt, int size) {
		super(cartPt);
		this.size = size;
	}
	@Override
	public double area() {
		return Math.pow(size, 2);
	}
	@Override
	public boolean contains(CartPt point) {
		return ShapeUtils.between(point.getX(), this.cartPt.getX(), this.size+this.cartPt.getX())
				&& ShapeUtils.between(point.getY(), this.cartPt.getY(), this.size + this.cartPt.getY());	}
	@Override
	public Rectangle boudingBox() {
		return new Rectangle(cartPt, this.size, this.size);
	}
	@Override
	public double perimeter() {
		return this.size * 4;
	}
}
