package ex_2;
/**
 * trong lop Book co 4 thuoc tinh va 5 phuong thuc:
 - String bookName
- double price
- int yearOfPublication
- Author author

+ boolean currentBook() => tra ve KDL boolean, return true neu quyen sach duoc xuat ban nam 2004 or 2003 va false neu khong phai
	return this.yearOfPublication == 2003 || this.yearOfPublication == 2004;
	
+ boolean currentAuthor() => tra ve KDL boolean, neu tac gia sinh sau 1940
	return this.author.getBirthYear() > 1940;
	
+ boolean thisAuthor(String that) => tra ve KDL boolean, neu tac gia nay giong voi ten tac gia duoc dua vao
	return this.author.getName().equals(that);

+ boolean sameAuthor(Book that) => tra ve KDL boolean, neu tac gia cua quyen sach nay trung ten voi tac gia quyen sach khac
	return this.author.getName().equals(that.author.getName());
	
+ boolean sameGeneration(Book that) => tra ve KDL boolean, neu 2 tac gia cua 2 quyen sach co nam sinh duoi 10 nam thi return ve true
		return Math.abs(this.author.getBirthYear() - that.author.getBirthYear()) >= 0 && Math.abs(this.author.getBirthYear() - that.author.getBirthYear()) < 10;
 
 	vidu:
	 	Author felleisen = new Author("Matthias Felleisen", 1960);
		Book htdch = new Book(felleisen, "How to Design Class Hierarchies", 0.0, 2004);
		
		Author friedman = new Author("Daniel P. Friedman", 1939);
		Book aljafp = new Book(friedman, "A Little Java, A Few Pattern", 25.9, 1998);
		
		//currentBook
		assertTrue(htdch.currentBook());
		assertFalse(aljafp.currentBook());
		//currentAuthor
		assertTrue(htdch.currentAuthor());
		assertFalse(aljafp.currentAuthor());
		//thisAuthor
		assertTrue(htdch.thisAuthor(htdch));
		assertFalse(htdch.thisAuthor(aljafp));
		//sameAuthor
		 assertTrue(htdch.sameAuthor(htdch));
		 assertFalse(htdch.sameAuthor(aljafp));
		 //sameGeneration
		 assertTrue(htdch.sameGeneration(htdch));
		 assertFalse(aljafp.sameGeneration(htdch));
 */
public class Book {
	 private String bookName;
	 private double price;
	 private int yearOfPublication;
	 private Author author;
	 //constructor
	public Book( Author author, String bookName, double price, int yearOfPublication) {
		this.author = author;
		this.bookName = bookName;
		this.price = price;
		this.yearOfPublication = yearOfPublication;
	}
	 //currentBook
	public boolean currentBook() {
		return this.yearOfPublication == 2003 || this.yearOfPublication == 2004;
	}
	//currentAuthor
	public boolean currentAuthor() {
		return this.author.getBirthYear() > 1940;
	}
	//thisAuthor
	public boolean thisAuthor(String that ) {
		return this.author.getName().equals(that);
	}
	//sameAuthor
	public boolean sameAuthor(Book that) {
		return this.author.getName().equals(that.author.getName());
	}
	//sameGeneration
	public boolean sameGeneration(Book that) {
		return Math.abs(this.author.getBirthYear() - that.author.getBirthYear()) >= 0 && Math.abs(this.author.getBirthYear() - that.author.getBirthYear()) < 10;
	}
}
