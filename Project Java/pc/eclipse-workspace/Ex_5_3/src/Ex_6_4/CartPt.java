package Ex_6_4;

import java.util.Objects;



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
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	//toString
	@Override
	public String toString() {
		return " ,CartPt: "+"x= " + x + ", y= " + y + ".";
	}
	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartPt other = (CartPt) obj;
		return x == other.x && y == other.y;
	}
	//translate
	public CartPt translate(int x, int y) {
		return new CartPt(this.x + x, this.y + y);
	}
	
}
