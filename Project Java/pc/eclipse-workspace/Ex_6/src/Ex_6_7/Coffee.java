package Ex_6_7;
/**
 * trong Coffee co 1 thuoc tinh:
 -String label
 
	*day la lop con duoc ke thua tu lop AnItem 
	*
	*vidu:
		AnItem ani1_1 = new Coffee("regular", "Laura Cafe", 12.900, 200.0);
		AnItem ani1_2 = new Coffee("regular", "Ralau cafe", 14.333, 220.0);
		
		assertEquals(ani1_1.unitPrice(), 0.0645);
		assertEquals(ani1_1.lowerPrice(123.999), true);
		assertEquals(ani1_1.cheaperThan(ani1_2), true);
 */
public class Coffee extends AnItem{
	private String label;//nhan
	//constructor
	public Coffee(String label, String brandName, double price, double gram) {
		super(brandName, price, gram);
		this.label = label;
		
	}
}
