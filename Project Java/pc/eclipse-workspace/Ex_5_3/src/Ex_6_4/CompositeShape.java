package Ex_6_4;
/**
 * trong CompositeShape co 2 thuoc tinh de tao ra cac hinh xep chong:
-IShape top
-IShape bottom

 */
public class CompositeShape implements IShape{
	private IShape top;//hinh tren
	private IShape bottom;//hinh duoi
	//private double tongX = 0;
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
	@Override
	public double getAveX() {

		double tongX = 0;
		 tongX = (double)this.top.getAveX() + (double)this.bottom.getAveX();
		return tongX/Count.count;		
	}
	@Override
	public double getAveY() {
		double tongY = 0;
		
		 tongY = (double)this.top.getAveY() + (double)this.bottom.getAveY();
		return tongY/Count.count;
	}
	@Override
	public double distanceToOrigin(double x, double y) {
		 Count.count = 0;
		return Math.sqrt(x*x + y*y);
	}
	@Override
	public boolean contains(CartPt that) {
		boolean boo = false;
		if(this.top.contains(that) == true || this.bottom.contains(that) == true) {
			boo = true;
		}
			return boo;
	}
	@Override
	public BoundingBox getBoundingBox() {
		BoundingBox topBoundingBox = top.getBoundingBox();
        BoundingBox bottomBoundingBox = bottom.getBoundingBox();
        
        int minX = Math.min(topBoundingBox.getMinX(), bottomBoundingBox.getMinX());
        int minY = Math.min(topBoundingBox.getMinY(), bottomBoundingBox.getMinY());
        int maxX = Math.max(topBoundingBox.getMaxX(), bottomBoundingBox.getMaxX());
        int maxY = Math.max(topBoundingBox.getMaxY(), bottomBoundingBox.getMaxY());

        return new BoundingBox(minX, minY, maxX, maxY);
    
	}
}
