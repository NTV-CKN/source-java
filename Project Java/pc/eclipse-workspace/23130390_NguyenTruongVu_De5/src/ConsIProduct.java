
public class ConsIProduct extends IProduct{
private Product first;
private IProduct rest;

	@Override
public String toString() {
	return "ConsIProduct [first=" + first +"\n"+ ", rest=" + rest + "]";
}

	public ConsIProduct(Product first, IProduct rest) {
	super();
	this.first = first;
	this.rest = rest;
}

	@Override
	public IProduct sortByTitle() {
		// TODO Auto-generated method stub
	
		return this.rest.sortByTitle().insert(first);
	}

	@Override
	public IProduct insert(Product that) {
		// TODO Auto-generated method stub
		IProduct ds = null;
		if(this.first.getNameProduct().compareTo(that.getNameProduct())<0) {
			ds = new ConsIProduct(that, this);
		}else {
			ds = new ConsIProduct(this.first, this.rest.insert(that));
		}
		return ds;
	}

	@Override
	public int totalSameProduct(String allowcate) {
		// TODO Auto-generated method stub
		int save = 0;
		if(this.first.getNameProduct().equals(allowcate)) {
			save = 1 + this.rest.totalSameProduct(allowcate);
		}else {
			save = this.rest.totalSameProduct(allowcate);
		}
		return save;
	}


	@Override
	public String sameAvailable() {
		// TODO Auto-generated method stub
		
		String str ="";
		if(this.rest.checkAvailable(first) ) {
			str = this.first+ this.rest.sameAvailable();
		}else {
			str = this.rest.sameAvailable();
		}
		return str;
	}

	@Override
	public boolean checkAvailable(Product that) {
		// TODO Auto-generated method stub
		return this.first.getAvailable() == that.getAvailable();
	}

	@Override
	public boolean checkProduct(Product that) {
		// TODO Auto-generated method stub
		boolean boo=false;
		if(this.first.equals(that)) {
			boo = true;
		}else {
			boo = this.rest.checkProduct(that);
		}
		return boo;
	}

	@Override
	public IProduct pL(String allowcate) {
		// TODO Auto-generated method stub
		IProduct ds = null;
		if(this.first.getAllocate().equals(allowcate)) {
			ds= new ConsIProduct(first, this.rest.pL(allowcate));
		}else {
			ds = this.rest.pL(allowcate);
		}
		return ds;
	}

}
