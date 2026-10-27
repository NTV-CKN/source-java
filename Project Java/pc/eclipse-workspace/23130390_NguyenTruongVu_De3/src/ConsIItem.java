
public class ConsIItem extends IItem{
private Product first;
private IItem rest;

	@Override
public String toString() {
	return "ConsIItem [first=" + first +"\n"+ ", rest=" + rest + "]";
}

	public ConsIItem(Product first, IItem rest) {
	super();
	this.first = first;
	this.rest = rest;
}

	@Override
	public IItem sortByTitle() {
		return this.rest.sortByTitle().insert(first);
	}
//ten giam dan
	@Override
	public IItem insert(Product that) {
		IItem ds = null;
		if(this.first.getName().compareTo(that.getName())>=0) {
			ds = new ConsIItem(that, this);
		}else {
			ds =new ConsIItem(this.first, this.rest.insert(that));
		}
		return ds;
	}

	@Override
	public String pL(int s) {
		String str = "";
		if(this.first.getAvailable()==s) {
			str = this.first+ this.rest.pL(s);
		}else {
			str = this.rest.pL(s);
		}
		return str;
	}

	@Override
	public String reName() {
		String str = "";
		if(this.first.getName().equals("Robot")) {
			this.first.setName("R2d2");
			str = this.first+ this.rest.reName();
		}else {
			str = this.rest.reName();
		}
		return str;
	}

	@Override
	public boolean checkProduct(Product that) {
		boolean boo = false;
		if(this.first.equals(that)) {
			boo = true;
		}else {
			boo = this.rest.checkProduct(that);
		}
		return boo;
	}

}
