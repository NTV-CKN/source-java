import java.text.NumberFormat;
import java.util.Locale;
/*
 * trong DescribeHouse co 4 thuoc tinh:
 * String kind
 * int numberOfRooms
 * String price
 * Address address
 * vidu:
 *new DescribeHouse("Ranch", 12, 123, new Address(1, "Tan Binh", "Tan Binh"));
 */
public class DescribeHouse {
	 private String kind;//loai 
	 private int numberOfRooms;//so cac phong
	 private int price;//gia theo dollar
	 private Address address;//dia chi
	 //constructor
	public DescribeHouse(String kind, int  numberOfRooms, int price, Address address) {
		this.kind = kind;
		this.numberOfRooms = numberOfRooms;
		this.price = price;
		this.address = address;
	}
}
	//format price
//	public String format(int price) {
//		Locale locale = new Locale("en", "US");
//		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
//		return nf.format(price);
//	}

