package Ex_6_6;
/**
 * trong ConsMail co 2 thuoc tinh va 2 phuong thuc Override lai tu IMail:
private Mail first
private IMail rest
 */
public class ConsMail extends IMail{
	private Mail first;
	private IMail rest;
	//constructor
	public ConsMail(Mail first, IMail rest) {
		super();
		this.first = first;
		this.rest = rest;
	}
	//this  <= that
	@Override
	public IMail insert(Mail that) {
		IMail ds = null;
		if(that.equalsDate(this.first)) {
			ds = new ConsMail(that, this);
		}else {
			ds = new ConsMail(this.first, this.rest.insert(that));
		}
		return ds;
	}
	@Override
	public String toString() {
		return "ConsMail [first=" + first +"\n"+ ", rest=" + rest + "]";
	}
	@Override
	public IMail sort() {
		return this.rest.sort().insert(this.first);
	}
	
}
