package Ex_3;
/**
 * trong Limo co 2 thuoc tinh:
-int yearOfPublication
-int seat
*lop nay duoc ke thua 2 thuoc tinh brand va model tu Verhicles
 */
public class Limo extends Verhicles{
	private int yearOfPublication;//nam san xuat
	private int seat;//so cho ngoi
	//constructor
	public Limo(String model, String brand, int yearOfPublication, int seat) {
		super(model, brand);
		this.yearOfPublication = yearOfPublication;
		this.seat = seat;
	}
	//getter and setter
	public int getYearOfPublication() {
		return yearOfPublication;
	}
	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	/**
	 *toString()
	 *vidu 		assertEquals(lm.toString(), "#hdb, Celes, 18, 2005");
	 *tra co dang super.toString() + this.getSeat() + ", "+ this.getYearOfPublication(); tra ve ket qua la "#hdb, Celes, 18, 2005"
	 */
	@Override
	public String toString() {
		return super.toString() + this.getSeat() + ", "+ this.getYearOfPublication();
	}
	
}
