/*
 * trong BookManagement co 4 thuoc tinh:
 * String title
 * int price
 * int yearOfPublication
 * Author author
 * vidu:
 * BookManagement bm = new BookManagement("Robinson Crusoe,", 15, 1719, new Author("Daniel Defoe,", 1660));
 */
public class BookManagement {
	 private String title;//ten sach
	 private int price;//gia sach
	 private int yearOfPublication;//nam xuat ban
	 private Author author;//tac gia
	 //constructor
	public BookManagement(String title, int price, int yearOfPublication, Author author) {
		this.title = title;
		this.price = price;
		this.yearOfPublication = yearOfPublication;
		this.author = author;
	}
}
