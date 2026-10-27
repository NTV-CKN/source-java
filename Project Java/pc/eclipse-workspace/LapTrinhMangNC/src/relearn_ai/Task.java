package relearn_ai;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * HEADER -> numBooks: int, size of record: long
 * DATA -> DATA of Book
 */
public class Task {
	public final int LEN_TITlE = 100;
	public final int LEN_AUTHOR = 60;

	RandomAccessFile raf;

	public Task() throws FileNotFoundException {
		raf = new RandomAccessFile("C:\\Users\\pc\\Downloads\\Newfolder - Copy1\\books.dat", "rw");
	}

	public void addBook(Book book) throws IOException {
		raf.seek(0);
		int numBooks = 0;
		int lenRecord;
		if (raf.length() == 0) {
			lenRecord = 4 + LEN_TITlE + LEN_AUTHOR + 4 + 8 + 1;
		} else {
			numBooks = raf.readInt();
			lenRecord = raf.readInt();
		}
		long lastIndex = 8 + (numBooks * lenRecord);
		raf.seek(lastIndex);
		book.writeBook(raf, LEN_AUTHOR, LEN_TITlE);
		// Update header
		raf.seek(0);
		raf.writeInt(numBooks + 1);
		raf.writeInt(lenRecord);
	}

	public Book getBook(int index) throws IOException {
		raf.seek(0);
		int numBooks = 0;
		int lenRecord;
		if (raf.length() == 0) {
			return null;
		} else {
			numBooks = raf.readInt();
			lenRecord = raf.readInt();
			if (numBooks <= index)
				return null;
		}
		raf.seek(8 + (index * lenRecord));
		int id = raf.readInt();
		String title = convertCharToStr(raf, LEN_TITlE);
		String author = convertCharToStr(raf, LEN_AUTHOR);
		int publishY = raf.readInt();
		double price = raf.readDouble();
		boolean available = raf.readBoolean();
		return new Book(id, title, author, publishY, price, available);
	}

	public void updateAvailability(int bookId, boolean status) {

	}

	public List<Book> searchByAuthor(String author) throws IOException {
		List<Book> books = new ArrayList<Book>();

		raf.seek(0);
		int numBooks = 0;
		int lenRecord;
		if (raf.length() == 0) {
			return books;
		} else {
			numBooks = raf.readInt();
			lenRecord = raf.readInt();
		}
		for (int i = 0; i < numBooks; i++) {
			raf.seek(8 + (i * lenRecord));
			int id = raf.readInt();
			String title = convertCharToStr(raf, LEN_TITlE);
			String authorT = convertCharToStr(raf, LEN_AUTHOR);
			if (authorT.equalsIgnoreCase(author)) {
				int publishY = raf.readInt();
				double price = raf.readDouble();
				boolean available = raf.readBoolean();
				books.add(new Book(id, title, authorT, publishY, price, available));
			}
		}
		return books;
	}

	public void deleteBook(int bookId) throws IOException {
		raf.seek(0);
		int numBooks = 0;
		int lenRecord;
		if (raf.length() == 0) {
			return;
		} else {
			numBooks = raf.readInt();
			lenRecord = raf.readInt();
		}
		for (int i = 0; i < numBooks; i++) {
			raf.seek(8 + (i * lenRecord));
			int id = raf.readInt();
			if (id == bookId) {
				int indexDelete = i;
				for (int j = i; j < numBooks - 1; j++) {
					raf.seek(8 + (j + 1 * lenRecord));
					int idNext = raf.readInt();
					String titleNext = convertCharToStr(raf, LEN_TITlE);
					String authorNext = convertCharToStr(raf, LEN_AUTHOR);
					int publishY = raf.readInt();
					double price = raf.readDouble();
					boolean available = raf.readBoolean();
					Book book = new Book(idNext, titleNext, authorNext, publishY, price, available);

					raf.seek(8 + (j * lenRecord));
					book.writeBook(raf, LEN_AUTHOR, LEN_TITlE);

					indexDelete = j + 1;
				}
			}
		}
		raf.seek(0);
		raf.writeInt(numBooks-1);
		raf.setLength(8 + ((numBooks - 1) * lenRecord));
	}

	private String convertCharToStr(RandomAccessFile raf, int len) throws IOException {
		String res = "";
		for (int i = 0; i < len / 2; i++) {
			char c;
			if ((c = raf.readChar()) != 0)
				res += c;
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		Task t = new Task();
//		t.addBook(new Book(1, "Noi Buon Chien Tranh", "Ngo Ba Kha", 1999, 10.2, false));
//		t.addBook(new Book(2, "Keo Son Kho doi", "Ngo Ba Kha", 1999, 10.2, false));
//		t.addBook(new Book(3, "Vo Nhat", "Kim Lan", 1999, 10.2, false));
//		t.addBook(new Book(4, "Uoc Ma Mi", "NGO BAO CHUNG", 1999, 10.2, false));
		System.out.println(t.getBook(1));
		System.out.println(Arrays.toString(t.searchByAuthor("Ngo Ba Kha").toArray()));
		t.deleteBook(1);
		System.out.println(Arrays.toString(t.searchByAuthor("Ngo Ba Kha").toArray()));
	}
}
