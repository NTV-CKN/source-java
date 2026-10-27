package Ex_5_7;
import junit.framework.*;
public class Test extends TestCase{
	public void test() {
		//kkhoi tao lop AnItem
		AnItem ani1_1 = new Coffee("regular", "Laura Cafe", 12.900, 200.0);
		AnItem ani1_2 = new Coffee("regular", "Ralau cafe", 14.333, 220.0);
		
		AnItem ani2_1 = new IceCream("Dong trung ha thao", "yogurt", "Cream", 19.0, 58.0);
		AnItem ani2_2 = new IceCream("Chon", "yogurt", "Cream Deli", 12.999, 23.0);
		
		AnItem ani3_1 = new Juice("Cam", "fresh",  "Teri", 22.000, 100.0);
		AnItem ani3_2 = new Juice("Cam", "fresh", "Ferry", 30.000, 120.0);
		
		IShoppingList ds1 = new ConsIShopping(ani1_1, new ConsIShopping(ani1_2, new ConsIShopping(ani3_1, new EmptyIShopping())));
		IShoppingList ds2 = new ConsIShopping(ani2_1, new ConsIShopping(ani1_1, new EmptyIShopping()));
		
		// lop Coffee
		assertEquals(ani1_1.unitPrice(), 0.0645);
		assertEquals(ani1_1.lowerPrice(123.999), true);
		assertEquals(ani1_1.cheaperThan(ani1_2), true);
		
		//khoi tao lop IceCream
		assertEquals(ani2_1.unitPrice(), 0.327, 0.01);
		assertEquals(ani2_1.lowerPrice(1), true);
		assertEquals(ani2_1.cheaperThan(ani2_2), true);
		
		//khoi tao Juice
		assertEquals(ani3_1.unitPrice(), 0.22);
		assertEquals(ani3_1.lowerPrice(0.1), false);
		assertEquals(ani3_1.cheaperThan(ani3_2), true);
		//howMany
		System.out.println("Numbers in list: "+ds1.howMany());
		System.out.println("Numbers in list "+ds2.howMany());
		System.out.println("============================");
		//brandList
		System.out.println(ds1.brandList());
		System.out.println(ds2.brandList());
		System.out.println("============================");
		//highestPrice
		System.out.println("HighestPrice= "+ds1.highestPrice());
		System.out.println("HighestPrice= "+ds2.highestPrice());
	}
}
