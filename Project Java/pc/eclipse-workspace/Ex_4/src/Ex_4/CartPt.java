package Ex_4;
/**
 * trong CartPt co 2 thuoc tinh va  5 phuong thuc:
-int x
-int y

+double distanceToO()=> tra ve khoang cach tu  hinh den goc toa do O
+double distanceTo(CartPt that)=> tra ve khoang cach tu diem den mot diem
+CartPt translate(int dx, int dy)=> dich
+int getX()=> lay gia tri X
+int getY()=> lay gia triY
 */
public class CartPt {
	private int x;//toa do x
	private int y;//toa do y
	//constructor
	public CartPt(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//getter and setter
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
	//distanceToO
	public double distanceToO() {
		return Math.sqrt((Math.pow(this.x, 2) + Math.pow(this.y, 2)));
	}
	//distanceTo
	public double distanceTo(CartPt cartpt) {
		return Math.sqrt((Math.pow(this.x - cartpt.getX(), 2) + Math.pow(this.y-cartpt.getY(), 2)));
	}
	//translate
	public CartPt translate(int x, int y) {
		return new CartPt(this.x + x, this.y + y);
	}
	
}
