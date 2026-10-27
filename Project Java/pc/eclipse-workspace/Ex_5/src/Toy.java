/**
 * trong Toy co 3 thuoc tinh:
-private String name
-private int available
-private double price
vidu
	Toy toy1 = new Toy("Khung long", 50, 50.000);
	Toy toy2 = new Toy("Bup be", 510, 505.000);
	Toy toy3 = new Toy("Xe dua", 10, 450.000);
 */
public class Toy {
	private String name;//ten
	private int available;//so luong
	private double price;//gia
	//constructor
	public Toy(String name, int available, double price) {
		this.name = name;
		this.available = available;
		this.price = price;
	}
	//toString
	@Override
	public String toString() {
		return name +" " + available+ " "  + price +" "+"; ";
	}
	
	
}
