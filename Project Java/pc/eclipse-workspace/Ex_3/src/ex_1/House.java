package ex_1;
/**
 * trong lop nay se co 4 thuoc tinh va 3 phuong thuc:
- String kind
-int numberOfRooms
-double price
-Address address

+ boolean hasMoreRooms(House that) => tra ve KDL boolean, return false neu nha nay co so phong it hon nha khac
va return true neu nha nay co nhieu phong hon nha khac:
	return this.numberOfRooms > that.numberOfRooms;
	
+ boolean inThisCity(String that)=> tra ve KDL boolean, return true neu this.aCity.equals(that) la dung va return false neu this.aCity.equals(that) la sai
	return this.address.getaCity().equals(that);
	
+ boolean sameCity(House that) => tra ve KDL boolean, return true neu 2 thanh pho giong nhau va false neu 2 thanh pho khac nhau
	return this.address.getaCity().equals(that.address.getaCity());
	vidu:
House house1 = new House("Ranch", 7,
new Address("23", "Mapple Street", "Brooklyn"), 375000);

House house2 = new House("Colonial", 9,
new Address("5", "Jove Road", "Newton"), 450000);

House house3 = new House("Cape", 6,
new Address("83", "Winslow Road", "Waltham"), 235000);

 -hasMoreRooms
assertFalse(house1.hasMoreRooms(house2));
assertTrue(house2.hasMoreRooms(house3));
-inThisCity
assertTrue(house1.inThisCity("Brooklyn"));
assertFalse(house1.inThisCity("Newton"));
-sameCity
assertTrue(house1.sameCity(house1));
assertFalse(house1.sameCity(house2));
 */
public class House {
	private String kind;
	private int numberOfRooms;
	private double price;
	private Address address;
	//constructor
	public House(String kind, int numberOfRooms,Address address, double price) {
		this.kind = kind;
		this.numberOfRooms = numberOfRooms;
		this.address = address;
		this.price = price;
	}
	//hasMoreRooms
	public boolean hasMoreRooms(House that) {
		return this.numberOfRooms > that.numberOfRooms;
	}
	//inThisCity
	public boolean inThisCity(String that) {
		return this.address.getaCity().equals(that);
	}
	//sameCity
	public boolean sameCity(House that) {
	return this.address.getaCity().equals(that.address.getaCity());
	}
}
