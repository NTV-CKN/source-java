package Ex_6_4;
import junit.framework.*;
public class Test extends TestCase{
	public void testIShape() {
		//khoi tao CartPt 
		CartPt that1 = new CartPt(13, 12);
		CartPt that2 = new CartPt(1, 12);
		CartPt that3 = new CartPt(2, 2);
		
		
		CartPt sq1 = new CartPt(4, 3);//cua Square 1
		CartPt sq2 = new CartPt(3, 4);//cua Square 2
		CartPt ci1 = new CartPt(0, 0);//Circle 1
		CartPt ci2 = new CartPt(12, 5);//Circle 2
		
		//IShape voi cons la ASingleShape
		IShape s1 = new Square(sq1, 40);
		IShape s2 = new Square(sq2, 50);
		IShape c1 = new Circle(ci1, 20);
		IShape c2 = new Circle(ci2, 20);
		//IShape voi cons la CompositeShape
		IShape is1 = new CompositeShape(s1, s2);
		IShape is2 = new CompositeShape(c1, c2);
		//sysout
		System.out.println(is1);
		System.out.println(is2);
		//distanceToOrigin
		System.out.println("==================");
		System.out.println(is1.distanceToOrigin(is1.getAveX(), is1.getAveY()));
		System.out.println(is2.distanceToOrigin(is2.getAveX(), is2.getAveY()));
		//contains
		System.out.println("==================");
		assertEquals(is1.contains(that1), false);
		assertEquals(is1.contains(that2), false);
		assertEquals(is1.contains(that3), true);
		//BoundingBox
		System.out.println(is1.getBoundingBox());
		System.out.println("==================");
		System.out.println(is2.getBoundingBox());
		
	}
}
