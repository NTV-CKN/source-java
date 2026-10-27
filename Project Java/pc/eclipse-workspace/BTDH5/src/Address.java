/*
 * trong Address co 3 thuoc tinh:
 * int houseNumber
 * String streetName
 * String city
 * vidu:
 * Address add = new Address(12, "Hoa Phu", "Phu Hoa");
 */
public class Address {
	private int houseNumber;//so nha
	 private String streetName;//ten duong
	 private String city;//ten thanh pho
	 //constructor
	public Address(int houseNumber, String streetName, String city) {
		this.houseNumber = houseNumber;
		this.streetName = streetName;
		this.city = city;
	}
	//toString
//	@Override
//	public String toString() {
//		return "Address [houseNumber=" + houseNumber + ", streetName=" + streetName + ", city=" + city + "]";
//	}
}
