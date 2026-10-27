package lab7_test;

import ex1.*;
import junit.framework.TestCase;

public class Ex1_Test extends TestCase {
	public void testEx1() {
		Book b1 = new Book(null, "1", null, 1, 1);
		Book b3 = new Book(null, "" + 9, null, 9, 9);
		Library lib = null;
		Book b2[] = new Book[20];
		for (int i = 0; i < 20; i++) {
			b2[i] = new Book(null, i + "", null, i, i);
		}
		LibraryMember libmem[] = { new LibraryMember("1", "1", b3) };
		lib = new Library(libmem, b2);

		StringBuilder strResult = new StringBuilder();
		strResult.append(lib.toString());

		// remove
		lib.removeBook(b1);
		assertFalse(strResult.toString().equals(lib.toString()));
		strResult.replace(0, strResult.length(), lib.toString());

		// add
		lib.addBook(b1);
		assertFalse(strResult.toString().equals(lib.toString()));
		strResult.replace(0, strResult.length(), lib.toString());
		// borrow
		lib.borrowBook("1", "1");
		assertFalse(strResult.toString().equals(lib.toString()));
		strResult.replace(0, strResult.length(), lib.toString());
		// return
		lib.returnBook("1", b2[1]);
		assertFalse(strResult.toString().equals(lib.toString()));
		strResult.replace(0, strResult.length(), lib.toString());
	}
}
