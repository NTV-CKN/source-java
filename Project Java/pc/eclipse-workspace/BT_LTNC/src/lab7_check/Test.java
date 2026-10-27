package lab7_check;

public class Test {
	public static void main(String[] args) {
		// book of mem
		Books[] bookMem1 = { new Books("Dac Nhan Tam", "123", "Thay", 2), new Books("Cha Gia", "321", "K", 1) };
		Books[] bookMem2 = { new Books("Nhan Gian", "909", "Thay", 2), new Books("Cha Gia", "321", "K", 2) };
		// book of lib
		Books[] bookLib = { new Books("Dac Nhan Tam", "123", "Thay", 2), new Books("Cha Gia", "321", "K", 10),
				new Books("Doraemon", "345", "Fuji", 1) };
		
		//create Lib and LibMem
		LibraryMembers[] libMem = {new LibraryMembers("Vu", "23130390", bookMem1), new LibraryMembers("Hien", "23130300", bookMem2)};
		Library lib = new Library(bookLib, libMem);
		
		System.out.println("Non borrow \n" + lib.getAvailableBooks());
		lib.borrowing("23130390", "123");
		System.out.println("After borrowed \n" + lib.getAvailableBooks());
		lib.returnBook("23130390", "123");
		System.out.println("After returned \n" + lib.getAvailableBooks());
		lib.addBook(new Books("Tay Du Ki", "888", "VD", 9));
		System.out.println("After add book \n" + lib.getAvailableBooks());
		lib.removeBook("");
	}
}
