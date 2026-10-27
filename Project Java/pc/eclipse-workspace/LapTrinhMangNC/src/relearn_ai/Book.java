package relearn_ai;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Book {
	int id;
	String title;
	String author;
	int publishYear;
	double price;
	boolean available;

	public Book(int id, String title, String author, int publishYear, double price, boolean available) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publishYear = publishYear;
		this.price = price;
		this.available = available;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + "\t" + title + "\t" + author + "\t" + publishYear + "\t" + price + "\t" + available;
	}

	public void writeBook(RandomAccessFile raf, int lenAuthor, int lenTitle) throws IOException {
		raf.writeInt(id);
		convertStrToChar(raf, lenTitle, title);
		convertStrToChar(raf, lenAuthor, author);
		raf.writeInt(publishYear);
		raf.writeDouble(price);
		raf.writeBoolean(available);
	}

	private void convertStrToChar(RandomAccessFile raf, int len, String value) throws IOException {
		for (int i = 0; i < len / 2; i++) {
			char c = 0;
			if(value.length() > i) c = value.charAt(i);
			raf.writeChar(c);
		}
	}
}
