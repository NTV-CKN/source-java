package Ex_6;
/**
 * trong Juice co 2 thuoc tinh:
-String flavor
-String isPackage

	*day la lop duoc ke thua tu AnItem
	*
	*vidu
		AnItem ani3_1 = new Juice("Cam", "fresh",  "Teri", 22.000, 100.0);
		AnItem ani3_2 = new Juice("Cam", "fresh", "Ferry", 30.000, 120.0);
		
		assertEquals(ani3_1.unitPrice(), 0.22);
		assertEquals(ani3_1.lowerPrice(0.1), false);
		assertEquals(ani3_1.cheaperThan(ani3_2), true);
 */
public class Juice extends AnItem{
	private String flavor;//huong vi
	private String isPackage;//xau goi
	//private AnItem anItem;//vat pham
	//constructor
	public Juice(String flavor, String isPackage, String brandName, double price, double gram) {
		super(brandName, price, gram);
		this.flavor = flavor;
		this.isPackage = isPackage;
}
}
