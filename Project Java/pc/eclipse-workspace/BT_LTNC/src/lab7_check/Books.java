package lab7_check;

import java.util.Objects;

public class Books {

	private String nameBook, id, author;

	private int available;

	// constructor
	public Books(String nameBook, String id, String author, int available) {
		this.nameBook = nameBook;
		this.id = id;
		this.author = author;
		this.available = available;
	}

	// get id of book
	public String getId() {
		return id;
	}

	// get available
	public int getAvailable() {
		return this.available;
	}

	// set available
	public void setAvailable(int available) {
		this.available = available;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Books other = (Books) obj;
		return Objects.equals(author, other.author) && Objects.equals(id, other.id)
				&& Objects.equals(nameBook, other.nameBook);
	}

	@Override
	public String toString() {
		return "Books [nameBook=" + nameBook + ", id=" + id + ", author=" + author + ", available=" + available + "]";
	}
}
