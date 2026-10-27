package ex1;

import java.util.Arrays;

public class Library {
	private LibraryMember[] listMem = new LibraryMember[10];
	private Book[] listBooks = new Book[10];
	private int indexCurrentBook = 0, indexCurrentMem = 0, saveIndex = -1;

	// constructor
	public Library(LibraryMember[] listMem, Book[] books) {
		this.listMem = listMem;
		this.listBooks = books;
		// add list book
		for (int i = 0; i < books.length; i++) {
			if (this.listBooks[listBooks.length - 1] != null) {
				this.listBooks = UpgradeSize.object(listBooks);
			}
			this.listBooks[indexCurrentBook] = books[indexCurrentBook];
			indexCurrentBook++;
		}
		// add list member
		for (int i = 0; i < listMem.length; i++) {
			if (this.listMem[listMem.length - 1] != null) {
				this.listMem = UpgradeSize.object(listMem);
			}
			this.listMem[indexCurrentMem] = listMem[indexCurrentMem];
			indexCurrentMem++;
		}
	}

	// is contain book
	public boolean isContainBook(Book book) {
		for (int i = 0; i < listBooks.length; i++) {
			if (listBooks[i] == null) {
				continue;
			}
			if (listBooks[i].equals(book)) {
				return true;
			}
		}
		return false;
	}

	// find book and member
	public Book findBook(String book) {
		for (int i = 0; i < listBooks.length; i++) {
			if (listBooks[i] == null || listBooks[i].getId() == null) {
				continue;
			}
			if (listBooks[i].getId().equals(book)) {
				saveIndex = i;

				return listBooks[i];
			}
		}
		saveIndex = -1;
		return null;
	}

	public LibraryMember findLibMem(String libmem) {
		for (int i = 0; i < listMem.length; i++) {
			if (listMem[i] == null || listMem[i].getIdMem() == null) {
				continue;
			}
			if (this.listMem[i].getIdMem().equals(libmem)) {
				saveIndex = i;
				return listMem[i];
			}
		}
		saveIndex = -1;
		return null;
	}

	// add book
	public void addBook(Book book) {
		if (this.listBooks[listBooks.length - 1] != null) {
			this.listBooks = UpgradeSize.object(listBooks);
		}
		this.listBooks[indexCurrentBook] = book;
		indexCurrentBook++;
	}

	// remove book
	public void removeBook(Book book) {
		for (int i = 0; i < listBooks.length; i++) {
			if (this.listBooks[i] == null) {
				continue;
			}

			if (this.listBooks[i].equals(book)) {
				for (int j = i; j < listBooks.length - 1; j++) {
					listBooks[j] = listBooks[j + 1];
				}
				this.listBooks[this.listBooks.length - 1] = null;
				indexCurrentBook--;
				return;
			}
		}
	}

	// borrow
	public void borrowBook(String idBook, String idMem) {
		Book bookSave = this.findBook(idBook);
		int iBook = saveIndex;
		LibraryMember libMem = this.findLibMem(idMem);
		int iLibMem = saveIndex;
		if (bookSave != null && libMem != null) {
			this.listBooks[iBook].setAvailable(this.listBooks[iBook].getAvailable() - 1);
			if (this.listBooks[iBook].getAvailable() < 1) {
				this.removeBook(this.listBooks[iBook]);
			}
			this.listMem[iLibMem].setAvailableLibMem(idBook, idMem, true);
		}
	}

	// return book
	public void returnBook(String idMem, Book book) {
		Book bookSave = this.findBook(book.getId());
		int iBook = saveIndex;
		LibraryMember libMem = this.findLibMem(idMem);
		int iLibMem = saveIndex;
		if (bookSave != null && libMem != null) {
			this.listBooks[iBook].setAvailable(this.listBooks[iBook].getAvailable() + 1);
			this.listMem[iLibMem].setAvailableLibMem(book.getId(), idMem, false);
		} else {
			if (libMem == null) {
				return;
			} else if (bookSave == null) {
				this.listMem[iLibMem].setAvailableLibMem(book.getId(), idMem, false);
				bookSave = new Book(book.getNameBook(), book.getId(), book.getCategory(), book.getYear(), 1);
				this.addBook(bookSave);
			}
		}
	}

	@Override
	public String toString() {
		return "listMem: \n" + Arrays.toString(listMem) + "\nlistBooks: \n" + Arrays.toString(listBooks);
	}
}
