package Ex_5_2;
/**
 * trong Book co 4 thuoc tinh:
private String title
private double price
private int yearOfPublication
private String nameAuthor
 */
public class Book {
	private String title;//ten
	private double price;//gia
	private int yearOfPublication;//nam xuat ban
	private String nameAuthor;//ten tac gia
	//constructor
	public Book(String title, double price, int yearOfPublication, String nameAuthor) {
		super();
		this.title = title;
		this.price = price;
		this.yearOfPublication = yearOfPublication;
		this.nameAuthor = nameAuthor;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", yearOfPublication=" + yearOfPublication
				+ ", nameAuthor=" + nameAuthor + "]";
	}
	
}
