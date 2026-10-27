package ex_2;
/**
 * trong Author_cont co 4 thuoc tinh:
     private String name;
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    
    
 */
import java.util.Objects;

public class Author_cont extends Book{
    private String name;
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    //constructor
	public Author_cont(Author author, String bookName, double price, int yearOfPublication, String name, int birthYear,
			int birthMonth, int birthDay) {
		super(author, bookName, price, yearOfPublication);
		this.name = name;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
	}
	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author_cont other = (Author_cont) obj;
		return birthDay == other.birthDay && birthMonth == other.birthMonth && birthYear == other.birthYear
				&& Objects.equals(name, other.name);
	}
	//thisAuthor
	public boolean thisAuthor(Author_cont that) {
		return this.equals(that);
	}
	//sameAuthor
	public boolean sameAuthor(Author_cont that) {
		return this.equals(that);

	}
}
