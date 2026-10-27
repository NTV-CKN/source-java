package Ex_6_8;
/**
 * trong ConsIBook co 2 thuoc tinh va 3 phuong thuc duoc Override lai tu IBook:
	private Record first;
	private IBook rest;
 */
public class ConsIBook extends IBook{
	private Record first;
	private IBook rest;
	//constructor
	public ConsIBook(Record first, IBook rest) {
		super();
		this.first = first;
		this.rest = rest;
	}
	@Override
	public String toString() {
		return "\n"+"ConsIBook [first=" + first +"\n"+ ", rest=" + rest + "]";
	}
	@Override
	public IBook thisAuthor(Record that) {
		ConsIBook save = (ConsIBook) this.rest.thisAuthor(that);
		if(this.first.author.equals(save.first.author) && this.first.title.equals(save.first.title)==false) {
		save = new ConsIBook(save.first, save.rest.thisAuthor(this.first));
		}
		else if(this.first.equals(save.first) == true){
		save = (ConsIBook) save;
		}
		return save;
	}
	@Override
	public IBook insert(Record that) {
		IBook ds = null;
		if(this.first.title.compareTo(that.title) > 0 || this.first.title.compareTo(that.title) == 0 ) {
			ds = new ConsIBook(this.first, rest.insert(that));
		}else {
			ds = new ConsIBook(that, this);
		}
		return ds;
	}
	@Override
	public IBook sortByTitle() {
		return this.rest.sortByTitle().insert(this.first);
	}
	
}
