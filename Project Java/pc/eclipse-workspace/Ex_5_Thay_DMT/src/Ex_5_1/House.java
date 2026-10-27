package Ex_5_1;
/**
 * trong House co 4 thuoc tinh:
-String kind
-String numberOfRoom
-double askPrice
-Address address
 */
public class House {
	private String kind;//loai
	private String numberOfRoom;//so phong
	private double askPrice;//gia
	private Address address;//dia chi
	//constructor
	public House(String kind, String numberOfRoom, double askPrice, Address address) {
		super();
		this.kind = kind;
		this.numberOfRoom = numberOfRoom;
		this.askPrice = askPrice;
		this.address = address;
	}
	@Override
	public String toString() {
		return "House [kind=" + kind + ", numberOfRoom=" + numberOfRoom + ", askPrice=" + askPrice + ", address="
				+ address + "]";
	}
	
}
