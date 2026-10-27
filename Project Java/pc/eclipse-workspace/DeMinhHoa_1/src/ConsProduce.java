
public class ConsProduce extends ListProduce{
private Produce first;
private ListProduce rest;
	public ConsProduce(Produce first, ListProduce rest) {
	this.first = first;
	this.rest = rest;
}

	@Override
	public String toString() {
		return "" + first +"\n"+ ", " + rest ;
	}

	@Override
	public boolean checkProduce(Produce that) {
		boolean boo = false;
		if(this.first.equals(that)) {
			boo = true;
		}else {
			boo = this.rest.checkProduce(that);
		}
		return boo;
	}

	@Override
	public String getDS(Produce that) {
		String str = "";
	if(this.first.equals(that)) {
		str = this.first.toString();
	
	}else {
		
	}
	return null;
	}

	@Override
	public ListProduce sortByTitle() {
		return this.rest.sortByTitle().insert(this.first);
	}

	@Override
	public ListProduce insert(Produce that) {
		ListProduce ds = null;
		if(that.produceName.compareTo(this.first.produceName)>= 0) {
			ds = new ConsProduce(that, this);
		}else {
			ds = new ConsProduce(this.first, this.rest.insert(that));
		}
		return ds;
	}

	@Override
	public double totalSL(String allocate) {
		double save=0;
		if(this.first.allocate.equals(allocate)) {
			save = this.first.available + this.rest.totalSL(allocate);
		}else {
			save = this.rest.totalSL(allocate);
		}
		return save;
	}

	@Override
	public String pLSP(String allocate) {
		String str = "";
		if(this.first.allocate.equals(allocate)) {
			str = this.first + this.rest.pLSP(allocate);
		}else {
			str = this.rest.pLSP(allocate);
		}
		return str;
	}



}
