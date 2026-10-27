package Ex_8;

import java.util.Objects;

/**
 * trong Record co 4 thuoc tinh va 3 phuong thuc:
# String title
# String author
# double price
# int publicationYear

+<abstract> double salePrice()=> tinh gia tien phai tra sau khi duoc giam cho moi quyen sach

+ boolean cheaperThan(ABook that)=> kiem tra gia tien quyen sach nay co re hon gia cua quyen sach khac khong
	return this.salePrice() < that.salePrice();
+ boolean sameAuthor(ABook that)=> kiem tra quyen sach nay co cung ten tac gia khong
	
 */
public abstract class Record {
	protected String title;//ten sach
	protected String author;//ten tac gia
	protected double price;//gia
	protected int publicationYear;//nam xuat ban
	//constructor
	public Record(String title, String author, double price, int publicationYear) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.publicationYear = publicationYear;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record other = (Record) obj;
		return Objects.equals(author, other.author);
	}
	//getter and setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	//salePrice()
	public abstract double salePrice();
	//cheaperThan
	public boolean cheaperThan(Record that) {
		return this.salePrice() < that.salePrice();
	}
	//sameAuthor
	public boolean sameAuthor(Record that) {
		return this.equals(that);
	}
}
