
public class ConsE extends ListE{
private Employee first;
private ListE rest;
	@Override
public String toString() {
	return "" + first +"\n"
			+  "" + rest ;
}

	public ConsE(Employee first, ListE rest) {
	super();
	this.first = first;
	this.rest = rest;
}

	@Override
	public int howManyE() {
		return this.first.count() + this.rest.howManyE();
	}

	@Override
	public String getSalers(Produce that) {
		String str="";
		str = this.rest.getSalers(that);
	if(this.first.isProduce(that)) {
		str = this.first + str;
	}
	return str;
}
	}
