package Ex_6_8;
/**
 * trong Hardcover duoc ke thua 4 thuoc tinh va 3 phuong thuc tu Record
 * 
 * vidu
 //Hardcover
		Hardcover hc1 = new Hardcover("Hello Cac Ban Minh La Toi Di Code Dao", "Pham Huy Hoang",189.00 , 2022);
		Hardcover hc2 = new Hardcover("Toi Di Code Dao", "Pham Huy Hoang",190.00 , 2022);
		
		//salePrice
		assertEquals(hc1.salePrice(), 151.2);
		//cheaperThan
		assertEquals(hc1.cheaperThan(hc2), true);
		//sameAuthor
		assertEquals(hc1.sameAuthor(hc2), true);
 */
public class Hardcover extends Record{
	//constructor
	public Hardcover(String title, String author, double price, int publicationYear) {
		super(title, author, price, publicationYear);
	}
	//salePrice
	@Override
	public double salePrice() {
		return this.price - (this.price*0.2);
	}


}
