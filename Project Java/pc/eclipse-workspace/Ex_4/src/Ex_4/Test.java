package Ex_4;
import junit.framework.*;
public class Test extends TestCase{

	public void testAShape() {
		//khoi tao CartPt
		CartPt cart1 = new CartPt(12, 12);
		CartPt cart2 = new CartPt(9, 12);
		CartPt cart3 = new CartPt(90, 12);
		CartPt cart4 = new CartPt(14, 12);
		//khoi tao AShape
		AShape as1 = new Circle(cart1, 7);
		AShape as2 = new Dot(cart2);
		AShape as3 = new Rectangle(cart3, 12, 9);
		AShape as4 = new Square(cart4, 6);
	}
	public void testIsShape() {
		//khoi tao CartPt
		CartPt cart1 = new CartPt(12, 12);
		CartPt cart2 = new CartPt(9, 12);
		CartPt cart3 = new CartPt(90, 12);
		CartPt cart4 = new CartPt(14, 12);
		//khoi tao IsShape
		IsShape is1 = new Circle(cart1, 7);
		IsShape is2 = new Dot(cart2);
		IsShape is3 = new Rectangle(cart3, 12, 9);
		IsShape is4 = new Square(cart4, 6);
		}
}
