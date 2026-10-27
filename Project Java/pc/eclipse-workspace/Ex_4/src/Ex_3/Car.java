package Ex_3;
/**
 * trong Car co 2 thuoc tinh:
-int seat
-boolean isAConvertible
*lop nay duoc ke thua 2 thuoc tinh brand va model tu Verhicles
 */
public class Car extends Verhicles{
	private int seat;//so cho ngoi
	private boolean isAConvertible;//la xe mui tran
	//constructor
	public Car(String model, String brand, int seat, boolean isAConvertible) {
		super(model, brand);
		this.seat = seat;
		this.isAConvertible = isAConvertible;
	}
	//getter and setter
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public boolean isAConvertible() {
		return isAConvertible;
	}
	public void setAConvertible(boolean isAConvertible) {
		this.isAConvertible = isAConvertible;
	}
	/**
	 *toString()
		 vidu assertEquals(car.toString(), "#hdc, KIA, 4, true");
	 *tra co dang super.toString() + this.getSeat()+", "+this.isAConvertible(); tra ve ket qua la "#hdc, KIA, 4, true"
	 */	@Override
	public String toString() {
		return super.toString() + this.getSeat()+", "+this.isAConvertible();
	}
	
}
