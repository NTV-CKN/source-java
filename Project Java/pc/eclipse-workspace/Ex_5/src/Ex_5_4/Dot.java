package Ex_5_4;
/**
 * trong Dot khong co thuoc tinh va phuong thuc nao
 * duoc extends tu lop ASingleShape
 */
public class Dot extends ASingleShape{
	//constructor
	public Dot(CartPt location) {
		super(location);
	}
	//toString
	@Override
	public String toString() {
		return "Dot"+this.location.toString();
	}
	
}
