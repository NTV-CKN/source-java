package Ex_4;
/**
 * trong Dot co  4 phuong thuc tu IsShape, 1 thuoc tinh ke thua tu AShape:
+area()
+boolean contains(CartPt point)
+Rectangle boundingBox()
+double perimeter()
 */
public class Dot extends AShape{

	public Dot(CartPt cartPt) {
		super(cartPt);
	}

	@Override
	public double area() {
		return 0;
	}

	@Override
	public boolean contains(CartPt point) {
		return ShapeUtils.between(point.getX(),this.cartPt.getX() ,this.cartPt.getX() )
				&& ShapeUtils.between(point.getY(),this.cartPt.getY() ,this.cartPt.getY() );
	}

	@Override
	public Rectangle boudingBox() {
		return new Rectangle(cartPt, 0, 0);
	}

	@Override
	public double perimeter() {
		return 1;
	}



}
