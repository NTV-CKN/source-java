package ex1;

import java.util.Arrays;
import java.util.Objects;

public class LibraryMember {

	private String nameMem, idMem;
	private Book booksPay[] = new Book[10];
	private int indexCurrent = 0, indexSave = -1;

	// constructor array
	public LibraryMember(String nameMem, String idMem, Book[] books) {
		this.nameMem = nameMem;
		this.idMem = idMem;
		for (int i = 0; i < books.length; i++) {
			if (this.booksPay[booksPay.length - 1] != null) {
				this.booksPay = UpgradeSize.object(booksPay);
			}
			this.booksPay[indexCurrent] = books[indexCurrent];
			indexCurrent++;
		}
	}

	// constructor class
	public LibraryMember(String nameMem, String idMem, Book books) {
		this.nameMem = nameMem;
		this.idMem = idMem;
		if (this.booksPay[booksPay.length - 1] != null) {
			this.booksPay = UpgradeSize.object(booksPay);
		}
		this.booksPay[indexCurrent] = books;
		indexCurrent++;
	}

	// equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LibraryMember other = (LibraryMember) obj;
		return Objects.equals(idMem, other.idMem) && Objects.equals(nameMem, other.nameMem);
	}

	// is contain id book
	public boolean isContainIdBook(String idBook) {
		for (int i = 0; i < booksPay.length; i++) {
			if (booksPay[i] == null || booksPay[i].getId() == null) {
				continue;
			}
			if (booksPay[i].getId().equals(idBook)) {
				indexSave = i;
				return true;
			}
		}
		return false;
	}

	// set available
	public void setAvailableLibMem(String idBook, String idMem, boolean bool) {
		// true = +, false = -
		boolean boo = this.isContainIdBook(idBook);
		if (boo) {
			if (!bool) {

				this.booksPay[indexSave].setAvailable(this.booksPay[indexSave].getAvailable() - 1);
				if (this.booksPay[indexSave].getAvailable() < 1) {
					this.removeBookMem(this.booksPay[indexSave]);
				}
			} else {
				this.booksPay[indexSave].setAvailable(this.booksPay[indexSave].getAvailable() + 1);
			}
		} else {
			this.addBookForLib(new Book("", idBook, "", -1, 1));
		}
	}

	// get list book of libmem
	public String getListBooks(Book[] booksPay) {
		StringBuilder strB = new StringBuilder();
		for (int i = 0; i < booksPay.length; i++) {
			strB.append(booksPay[i]);
		}
		return strB.toString();
	}

	// add book
	public void addBookForLib(Book book) {

		if (this.booksPay[booksPay.length - 1] != null) {
			this.booksPay = UpgradeSize.object(booksPay);
		}
		this.booksPay[indexCurrent] = book;
		indexCurrent++;
	}

	// remove
	public void removeBookMem(Book book) {
		for (int i = 0; i < booksPay.length; i++) {
			if (this.booksPay[i].equals(book)) {
				for (int j = i; j < booksPay.length - 1; j++) {
					booksPay[j] = booksPay[j + 1];
				}
				this.booksPay[this.booksPay.length - 1] = null;
				indexCurrent--;
				return;
			}
		}
	}

	public String getIdMem() {
		return idMem;
	}

	@Override
	public String toString() {
		return "LibraryMember: " + nameMem + ", idMem: " + idMem + ", booksPay:\n" + this.getListBooks(booksPay);
	}
}
