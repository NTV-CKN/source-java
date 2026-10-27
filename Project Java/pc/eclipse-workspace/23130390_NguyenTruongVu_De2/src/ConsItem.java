
public class ConsItem extends IItem{
private Item first;
private IItem rest;
	@Override
public String toString() {
	return "ConsItem [first=" + first + "\n"+", rest=" + rest + "]";
}

	public ConsItem(Item first, IItem rest) {
	super();
	this.first = first;
	this.rest = rest;
}

	@Override
	public boolean checkProduct(Item that) {
		boolean boo = false;
		if(this.first.equals(that)) {
			boo = true;
		}else {
			boo = this.rest.checkProduct(that);
		}
		return boo;
	}

	@Override
	public IItem sortByTitle() {
		return this.rest.sortByTitle().insert(first);
	}

	@Override
	public IItem insert(Item that) {
		IItem ds = null;
		if(this.first.produceName.compareTo(that.produceName) <= 0) {
			ds = new ConsItem(that, this);
		}else {
			ds = new ConsItem(this.first, this.rest.insert(that));
		}
		return ds;
	}

	@Override
	public int total(String name) {
		// TODO Auto-generated method stub
		int save = 0;
		if(this.first.manufactor.equals(name)) {
			save = 1 + this.rest.total(name);
		}
		return save;
	}

	@Override
	public String pL(String name) {
		// TODO Auto-generated method stub
		String str ="";
		if(this.first.manufactor.equals(name)) {
			str = this.first.toString() + this.rest.pL(name);
		}else {
			str = this.rest.pL(name);
		}
		return str;

	}

}
