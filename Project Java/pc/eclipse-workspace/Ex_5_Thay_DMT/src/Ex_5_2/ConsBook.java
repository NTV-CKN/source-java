package Ex_5_2;
/**
 * trong ConsBook co 2 thuoc tinh:
private Book first
private IBook rest
 */
public class ConsBook implements IBook{
	private Book first;
	private IBook rest;
	//constructor
	public ConsBook(Book first, IBook rest) {
		super();
		this.first = first;
		this.rest = rest;
	}
	@Override
	public String toString() {
		return "ConsBook [first=" + first + ", rest=" + rest + "]";
	}
	
}
