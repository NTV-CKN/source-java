package Ex_8;
import junit.framework.*;
public class Test extends TestCase{
	public void test() {
		//Hardcover
		Hardcover hc1 = new Hardcover("Hello Cac Ban Minh La Toi Di Code Dao", "Pham Huy Hoang",189.00 , 2022);
		Hardcover hc2 = new Hardcover("Toi Di Code Dao", "Pham Huy Hoang",190.00 , 2022);
		
		//salePrice
		assertEquals(hc1.salePrice(), 151.2);
		//cheaperThan
		assertEquals(hc1.cheaperThan(hc2), true);
		//sameAuthor
		assertEquals(hc1.sameAuthor(hc2), true);
		
		//Sale
		Sale sl1= new Sale("Bi Quyet Chon Nghe", "Ho Ngoc Trinh", 100.000, 2018);
		Sale sl2= new Sale("Cam Nang Chon Nghe", "Ho Ngoc Ha", 120.000, 2008);
		
		//salePrice
		assertEquals(sl1.salePrice(), 50.0);
		//cheaperThan
		assertEquals(sl1.cheaperThan(sl2), true);
		//sameAuthor
		assertEquals(sl1.sameAuthor(sl2), false);
		
		//Paperback
		Paperback pb1 = new Paperback("Buc Pha 9+", "Nguyen Truong Vu", 500.000, 2023);
		Paperback pb2 = new Paperback("Buc Pha 8+", "Nguyen Truong Vu", 120.000, 2023);
		
		//salePrice
		assertEquals(pb1.salePrice(), 500.000);
		//cheaperThan
		assertEquals(pb1.cheaperThan(pb2), false);
		//sameAuthor
		assertEquals(pb1.sameAuthor(pb2), true);

	}
}
