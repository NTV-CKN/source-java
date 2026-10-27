package Ex_8;
/**
* trong Sale duoc ke thua 4 thuoc tinh va 3 phuong thuc tu Record

vidu
		//Sale
		Sale sl1= new Sale("Bi Quyet Chon Nghe", "Ho Ngoc Trinh", 100.000, 2018);
		Sale sl2= new Sale("Cam Nang Chon Nghe", "Ho Ngoc Ha", 120.000, 2008);
		
		//salePrice
		assertEquals(sl1.salePrice(), 50.0);
		//cheaperThan
		assertEquals(sl1.cheaperThan(sl2), true);
		//sameAuthor
		assertEquals(sl1.sameAuthor(sl2), false);
 */
public class Sale extends Record{
	//constructor
	public Sale(String title, String author, double price, int publicationYear) {
		super(title, author, price, publicationYear);
	}
	//salePrice
	@Override
	public double salePrice() {
		return this.price -(this.price*0.5);
	}

}
