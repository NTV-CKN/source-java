package ex1;

public class Ex1 {
	public static void main(String[] args) {
		Book b1 = new Book(null, "1", null, 1, 1);
		Book b3 = new Book(null, "" + 9, null, 9, 9);
		Library lib = null;
		Book b2[] = new Book[20];
		for (int i = 0; i < 20; i++) {
			b2[i] = new Book(null, i + "", null, i, i);
		}
		LibraryMember libmem[] = { new LibraryMember("1", "1", b3) };
		lib = new Library(libmem, b2);

		System.out.println(lib.toString());
		System.out.println("==============");
		lib.removeBook(b1);
		System.out.println(lib.toString());
		lib.addBook(b1);
		System.out.println("==============");
		System.out.println(lib.toString());
		System.out.println("==============");
		lib.borrowBook("1", "1");
		System.out.println(lib.toString());
		System.out.println("==============");
		lib.returnBook("1", b2[1]);
		System.out.println(lib.toString());
	}
}
