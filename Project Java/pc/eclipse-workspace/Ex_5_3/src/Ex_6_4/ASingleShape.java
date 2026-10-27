package Ex_6_4;
/**
 * trong ASingleShape co 1 thuoc tinh:
#CartPt location
day la lop cha cua cac hinh va la lop implements lai tu Interface IShape

vidu
		IShape s1 = new Square(sq1, 40);
		IShape s2 = new Square(sq2, 50);
		IShape c1 = new Circle(ci1, 20);
		IShape c2 = new Circle(ci2, 20);
 */
public abstract class ASingleShape implements IShape{
	protected CartPt location;//toa do xy
	//constructor
	public ASingleShape(CartPt location) {
		this.location = location;
	}
	@Override
	public double getAveX() {
		Count.count();
		return location.getX();
	}
	@Override
	public double getAveY() {
	//	Count.count();
		return location.getY();
	}
	@Override
	public double distanceToOrigin(double x, double y) {
		return Math.sqrt(x*x + y*y);
	}
	@Override
	public boolean contains(CartPt that) {
		return this.location.getX() > that.getX() && this.location.getY() > that.getY();
	}
	@Override
	public  abstract BoundingBox getBoundingBox();
}
