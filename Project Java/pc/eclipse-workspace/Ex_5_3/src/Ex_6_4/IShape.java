package Ex_6_4;
/**
 * day la Interface co chua2 cons de tao 1 list cac hinh phu len nhau
 * trong 
 * 
 * vidu
		IShape is1 = new CompositeShape(s1, s2);
		IShape is2 = new CompositeShape(c1, c2);
		System.out.println(is1);
		System.out.println(is2);
		
		System.out.println(is1.distanceToOrigin(is1.getAveX(), is1.getAveY()));=>4.9
		System.out.println(is2.distanceToOrigin(is2.getAveX(), is2.getAveY()));=>6.5
		
		assertEquals(is1.contains(that1), false);
		assertEquals(is1.contains(that2), false);
		assertEquals(is1.contains(that3), true);
		
		System.out.println(is1.getBoundingBox());
			=>minX=3, minY=3, maxX=53, maxY=54
		System.out.println(is2.getBoundingBox());
			=>minX=-20, minY=-20, maxX=32, maxY=25
 */
public interface IShape {
	public double getAveX();
	public double getAveY();
	public double distanceToOrigin(double x, double y);
	public boolean contains(CartPt that);
	public BoundingBox getBoundingBox();
	
}
