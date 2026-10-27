package ex1;

import java.util.Objects;

public class Book {
	private String nameBook, id, category;
	private int year, available;

	// constructor
	public Book(String nameBook, String id, String category, int year, int available) {
		this.nameBook = nameBook;
		this.id = id;
		this.category = category;
		this.year = year;
		this.available = available;
	}

	// getter and setter
	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public String getNameBook() {
		return nameBook;
	}

	public String getCategory() {
		return category;
	}

	public int getYear() {
		return year;
	}

	public String getId() {
		return id;
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
		Book other = (Book) obj;
		return Objects.equals(category, other.category) && Objects.equals(id, other.id)
				&& Objects.equals(nameBook, other.nameBook) && year == other.year;
	}

	@Override
	public String toString() {
		return "nameBook: " + nameBook + ", id: " + id + ", category: " + category + ", year: " + year + ", available: "
				+ available + "\n";
	}

}
