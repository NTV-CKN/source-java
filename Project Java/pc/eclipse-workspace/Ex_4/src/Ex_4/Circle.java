package Ex_4;
/**
 * trong Circle co 1 thuoc tinh va 4 phuong thuc tu IsShape, 1 thuoc tinh ke thua tu AShape:
+area()
+boolean contains(CartPt point)
+Rectangle boundingBox()
+double perimeter()

-int radius
 */
public class Circle extends AShape{	
	private int radius;//ban kinh
	//constructor
	public Circle(CartPt cartPt, int r) {
		super(cartPt);
		this.radius = r;
	}
	@Override
	public double area() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public boolean contains(CartPt point) {
		return ShapeUtils.between(point.getX(), 0, this.radius)
				&& ShapeUtils.between(point.getY(), 0, this.radius );
		}

	@Override
	public Rectangle boudingBox() {
		return new Rectangle(cartPt.translate(-this.radius, -this.radius), this.radius*2, this.radius*2);
	}

	@Override
	public double perimeter() {
		return Math.PI*2*this.radius;
	}


}
