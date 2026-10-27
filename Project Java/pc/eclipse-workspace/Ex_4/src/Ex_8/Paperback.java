package Ex_8;
/**
 * trong Paperback duoc ke thua 4 thuoc tinh va 3 phuong thuc tu Record
 
 vidu
 		//Paperback
		Paperback pb1 = new Paperback("Buc Pha 9+", "Nguyen Truong Vu", 500.000, 2023);
		Paperback pb2 = new Paperback("Buc Pha 8+", "Nguyen Truong Vu", 120.000, 2023);
		
		//salePrice
		assertEquals(pb1.salePrice(), 500.000);
		//cheaperThan
		assertEquals(pb1.cheaperThan(pb2), false);
		//sameAuthor
		assertEquals(pb1.sameAuthor(pb2), true);
 */
public class Paperback extends Record{
	//constructor
	public Paperback(String title, String author, double price, int publicationYear) {
		super(title, author, price, publicationYear);
	}
	//salePrice()
	@Override
	public double salePrice() {
		return this.price;
	}

	

}
