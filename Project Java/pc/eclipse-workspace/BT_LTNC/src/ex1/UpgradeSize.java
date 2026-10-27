package ex1;

public class UpgradeSize {
	public static Book[] object(Book[] other) {
		Book[] obj = new Book[other.length + 10];
		for (int i = 0; i < other.length; i++) {
			obj[i] = other[i];
		}
		return obj;
	}

	public static LibraryMember[] object(LibraryMember[] other) {
		LibraryMember[] obj = new LibraryMember[other.length + 10];
		for (int i = 0; i < other.length; i++) {
			obj[i] = other[i];
		}
		return obj;
	}
}
