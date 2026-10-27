package Ex_5_2;

import junit.framework.TestCase;
public class BookTest extends TestCase {
	public void test() {
		Book b1 = new Book("Robinson Crusoe", 15.50, 1719, "Daniel Defoe");
		Book b2 = new Book("Heart of Darkness", 12.80, 1902, "Joseph Conrad");
		Book b3 = new Book("Beach Music", 9.50, 1996, "Pat Conroy");
		//list
		IBook ds1 = new ConsBook(b3, new MTBook());
		IBook ds2 = new ConsBook(b1, ds1);
		System.out.println(ds1);
		System.out.println(ds2);
	}
}
