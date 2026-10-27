package Ex_6;
/**
 * trong IceCream co 3 thuoc tinh:
-String flavor
-String isPackage
-AnItem anItem

	*day la lop con duoc ke thua tu lop AnItem 
	*vidu:
	*
		AnItem ani2_1 = new IceCream("Dong trung ha thao", "yogurt", "Cream", 19.0, 58.0);
		AnItem ani2_2 = new IceCream("Chon", "yogurt", "Cream Deli", 12.999, 23.0);
		
		assertEquals(ani2_1.unitPrice(), 0.327, 0.01);
		assertEquals(ani2_1.lowerPrice(1), true);
		assertEquals(ani2_1.cheaperThan(ani2_2), true);
		
 */
public class IceCream extends AnItem {
	private String flavor;//huong vi
	private String isPackage;//xau goi
	//private AnItem anItem;//vat pham
	//constructor
	public IceCream(String flavor, String isPackage, String brandName, double price, double gram) {
		super(brandName, price, gram);
		this.flavor = flavor;
		this.isPackage = isPackage;
		
	}
	
}
