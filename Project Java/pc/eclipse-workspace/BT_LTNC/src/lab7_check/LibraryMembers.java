package lab7_check;

import java.util.ArrayList;
import java.util.List;

public class LibraryMembers {
	private String name, id;
	private List<Books> listBooksBorrow = new ArrayList<Books>();

	// constructor list array
	public LibraryMembers(String name, String id, Books[] books) {
		this.name = name;
		this.id = id;
		for (int i = 0; i < books.length; i++) {
			this.listBooksBorrow.add(books[i]);
		}
	}

	// constructor class
	public LibraryMembers(String name, String id, Books book) {
		this.name = name;
		this.id = id;
		this.listBooksBorrow.add(book);
	}

	// get id
	public String getId() {
		return id;
	}

	// add book into list books borrow
	public void addBookBorrow(Books book) {
		this.listBooksBorrow.add(book);
	}

	// return book if same id book and id mem
	public Books returnBook(String idMem, String idBook) {
		for (int i = 0; i < listBooksBorrow.size(); i++) {
			if (this.listBooksBorrow.get(i).getId().equals(idBook)) {
				return this.listBooksBorrow.get(i);
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "LibraryMembers [name=" + name + ", id=" + id + ", listBooksBorrow=" + listBooksBorrow.toString() + "]";
	}
}
