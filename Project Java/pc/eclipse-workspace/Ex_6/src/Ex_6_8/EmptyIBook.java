package Ex_6_8;
/**
 * trong EmptyIBook co 3 methods duoc Override lai tu IBook
 */
public class EmptyIBook extends IBook{



	@Override
	public IBook insert(Record that) {
		return new ConsIBook(that, new EmptyIBook());
	}

	@Override
	public String toString() {
		return "";
	}

	@Override
	public IBook sortByTitle() {
		return new EmptyIBook();
	}

	@Override
	public IBook thisAuthor(Record that) {
		return  new ConsIBook(that, new EmptyIBook());
	}

}
