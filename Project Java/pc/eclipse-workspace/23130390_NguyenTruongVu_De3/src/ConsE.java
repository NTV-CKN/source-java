
public class ConsE extends IListE{
private Employee first;
private IListE rest;
	@Override
public String toString() {
	return "ConsE [first=" + first +"\n"+ ", rest=" + rest + "]";
}

	public ConsE(Employee first, IListE rest) {
	super();
	this.first = first;
	this.rest = rest;
}

	@Override
	public int howManyE() {
		// TODO Auto-generated method stub
		return this.first.count() + this.rest.howManyE();
	}

	@Override
	public String getSalers(Product that) {
		String str= "";
		if(this.first.isProduct(that)) {
			str = this.first + this.rest.getSalers(that);
		}else {
			str = this.rest.getSalers(that);
		}
		return str;
	}

}
