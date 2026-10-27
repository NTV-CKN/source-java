package Ex_5_4;
/**
 * trong CompositeShape co 2 thuoc tinh de tao ra cac hinh xep chong:
-IShape top
-IShape bottom

 */
public class CompositeShape implements IShape{
	private IShape top;//hinh tren
	private IShape bottom;//hinh duoi
	//constructor
	public CompositeShape(IShape top, IShape bottom) {
		this.top = top;
		this.bottom = bottom;
	}
	//toString
	@Override
	public String toString() {
		return "CompositeShape: Top: " + top.toString() + ", bottom: " + bottom.toString();
	}
}
