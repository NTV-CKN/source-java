package Ex_5_4;
import junit.framework.*;
public class Test extends TestCase{
	public void testIShape() {
		//khoi tao CartPt 
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
	}
}
