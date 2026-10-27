package Ex_5_1;
/**
 * trong Address co 3 thuoc tinh:
-int houseNumber
-String streetName
-String aCity
 */
public class Address {
	private int houseNumber;//so nha
	private String streetName;//ten duong
	private String aCity;//ten thanh pho
	//constructor
	public Address(int houseNumber, String streetName, String aCity) {
		super();
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.aCity = aCity;
	}
	@Override
	public String toString() {
		return "Address [houseNumber=" + houseNumber + ", streetName=" + streetName + ", aCity=" + aCity + "]";
	}
}
