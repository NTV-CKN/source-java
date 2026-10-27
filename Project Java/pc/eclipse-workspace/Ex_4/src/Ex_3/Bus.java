package Ex_3;
/**
 * trong Bus co 2 thuoc tinh:
-String id
-int seat
 *lop nay duoc ke thua 2 thuoc tinh brand va model tu Verhicles
 */
public class Bus extends Verhicles{
	private String id;//ma so xe
	private int seat;//so cho ngoi
	//constructor
	public Bus(String model, String brand, String id, int seat) {
		super(model, brand);
		this.id = id;
		this.seat = seat;
	}
	//getter and setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	/**
	 * toString
	 * vidu 	assertEquals(b.toString(), "#hds, NhaTr, #123, 18");
	 * b.toString() chinh la super.toString() + this.getId() + ", " + this.getSeat() xau thanh chuoi co ket qua la  "#hds, NhaTr, #123, 18"
	 */
	@Override
	public String toString() {
		return super.toString() + this.getId() + ", " + this.getSeat();
	}
	
}
