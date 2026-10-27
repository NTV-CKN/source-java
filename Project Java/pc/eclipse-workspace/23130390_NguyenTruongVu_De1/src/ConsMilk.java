
public class ConsMilk extends IMilk{
private Milk first;
private IMilk rest;
	@Override
public String toString() {
	return "ConsMilk [first=" + first +"\n"+ ", rest=" + rest + "]";
}

	public ConsMilk(Milk first, IMilk rest) {
	super();
	this.first = first;
	this.rest = rest;
}

	@Override
	public IMilk sortByVolumn() {
		return this.rest.sortByVolumn().insert(first);
	}
//tang dan
	@Override
	public IMilk insert(Milk that) {
		IMilk ds = null;
		if(this.first.volumn() >= that.volumn()) {
			ds = new ConsMilk(that, this);
		}else {
			ds = new ConsMilk(this.first, this.rest.insert(that));
		}
		return ds;
	}

	@Override
	public String listSameManufactor(Manufactor that) {
		String str="";
		if(this.first.mF.equals(that)){
			str = this.first.toString() + this.rest.listSameManufactor(that);
		}else {
			str = this.rest.listSameManufactor(that);
		}
		return str;
	}

	@Override
	public IMilk deleteExpired() {
		IMilk ds = null;
		if(this.first.isExpired()) {
			ds =  this.rest.deleteExpired();
		}else {
			ds = new ConsMilk(this.first, this.rest.deleteExpired());
		}
		return ds;
	}

}
