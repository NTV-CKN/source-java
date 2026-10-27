package lab7_check;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Books> listBooks = new ArrayList<Books>();
	private List<LibraryMembers> listLM = new ArrayList<LibraryMembers>();

	// constructor arrays
	public Library(Books[] books, LibraryMembers[] libraryMembers) {
		for (int i = 0; i < books.length; i++) {
			this.listBooks.add(books[i]);
		}
		for (int i = 0; i < libraryMembers.length; i++) {
			this.listLM.add(libraryMembers[i]);
		}
	}

	// constructor class
	public Library(Books book, LibraryMembers libMem) {
		this.listBooks.add(book);
		this.listLM.add(libMem);
	}

	// method
	// add book
	public void addBook(Books book) {
		this.listBooks.add(book);
	}

	// find book in list book
	public int indexBook(Books book) {
		for (int i = 0; i < listBooks.size(); i++) {
			if (listBooks.get(i).equals(book)) {
				return i;
			}
		}
		return -1;
	}

	// remove book
	public void removeBook(String idBook) {
		for (int i = 0; i < listBooks.size(); i++) {
			if (this.listBooks.get(i).getId().equals(idBook)) {
				listBooks.remove(i);
			}
		}
	}

	// borrowing
	public void borrowing(String idMem, String idBook) {
		Books book = null;
		LibraryMembers libMem = null;
		for (int i = 0; i < listBooks.size(); i++) {
			book = this.listBooks.get(i);
			if (book.getId().equals(idBook)) {
				book.setAvailable(book.getAvailable() - 1);
				break;
			}
		}

		for (int i = 0; i < listBooks.size(); i++) {
			libMem = this.listLM.get(i);
			if (libMem.getId().equals(idMem)) {
				libMem.addBookBorrow(book);
				if (book.getAvailable() <= 0)
					this.listBooks.remove(book);
				break;
			}
		}
	}

	// return book
	public void returnBook(String idMem, String idBook) {
		Books bookSave = null;
		for (int i = 0; i < listLM.size(); i++) {
			if (this.listLM.get(i).getId().equals(idMem)) {
				bookSave = this.listLM.get(i).returnBook(idMem, idBook);
				if (bookSave != null) {
					int index = this.indexBook(bookSave);
					if (index > -1)
						this.listBooks.get(index).setAvailable(this.listBooks.get(index).getAvailable() + 1);
					else 
						this.listBooks.add(bookSave);
					return;
				} 
			}
		}
	}

	// get available of list book
	public String getAvailableBooks() {
		StringBuilder strB = new StringBuilder();
		for (int i = 0; i < listBooks.size(); i++) {
			strB.append(this.listBooks.get(i).getAvailable() + "\n");
		}
		return strB.toString();
	}

	@Override
	public String toString() {
		return "Library [listBooks=" + listBooks.toString() + ", listLM=" + listLM.toString() + "]";
	}
}
