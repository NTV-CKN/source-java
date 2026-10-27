package Ex_5_4;
/**
 * trong CartPt co 2 thuoc tinh:
 -int x
 -int y
 
 vidu
 		CartPt sq1 = new CartPt(4, 3);//cua Square 1
		CartPt sq2 = new CartPt(3, 4);//cua Square 2
		CartPt ci1 = new CartPt(0, 0);//Circle 1
		CartPt ci2 = new CartPt(12, 5);//Circle 2
 */
public class CartPt {
	private int x;//toa do x
	private int y;//toa do y
	//constructor
	public CartPt(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//toString
	@Override
	public String toString() {
		return " ,CartPt: "+"x= " + x + ", y= " + y + ".";
	}
	
}
