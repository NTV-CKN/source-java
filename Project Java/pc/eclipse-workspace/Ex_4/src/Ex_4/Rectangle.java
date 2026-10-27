package Ex_4;
/**
 * trong Rectangle co 2 thuoc tinh va 4 phuong thuc tu IsShape, 1 thuoc tinh ke thua tu AShape:
+area()
+boolean contains(CartPt point)
+Rectangle boundingBox()
+double perimeter()

-int width
-int height
 */
public class Rectangle extends AShape{
	private int width, height;//chieu rong chieu dai
	
//	public Rectangle(CartPt cartPt,  double w, double h) {
//		super(cartPt);
//		if(w%1>= 0.5 && h%1 >= 0.5) {
//		this.width =(int) w + 1;
//		this.height = (int) h + 1;
//		}else if(w%1 >= 0.5 && h%1 < 0.5) {
//			this.width =(int) w + 1;
//			this.height =(int) h;
//		}else if(w%1 < 0.5 && h%1 >= 0.5) {
//			this.width =(int) w;
//			this.height =(int) h + 1;
//		}else if(w%1 < 0.5 && h%1 < 0.5){
//			this.width =(int) w;
//			this.height = (int) h;
//		}
//	}

	@Override
	public double area() {
		return this.height * this.width;
	}
	//constructor
	public Rectangle(CartPt cartPt, int width, int height) {
		super(cartPt);
		this.width = width;
		this.height = height;
	}

	@Override
	public boolean contains(CartPt point) {
		return ShapeUtils.between(point.getX(), this.width, this.width+this.cartPt.getX())
				&& ShapeUtils.between(point.getY(), this.height, this.height + this.cartPt.getY());
	}

	@Override
	public Rectangle boudingBox() {
		return new Rectangle(cartPt, width, height);
	}

	@Override
	public double perimeter() {
		return (this.width+this.height)*2;
	}

	

}
