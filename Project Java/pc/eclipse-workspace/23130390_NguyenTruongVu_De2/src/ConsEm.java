
public class ConsEm extends IList{
@Override
	public String toString() {
		return "ConsEm [first=" + first + "\n"+", rest=" + rest + "]";
	}
private Employee first;
private IList rest;
public ConsEm(Employee first, IList rest) {
	super();
	this.first = first;
	this.rest = rest;
}
@Override
public int howManyEmployee() {
	return this.first.count()+ this.rest.howManyEmployee();
}
@Override
public String getSalers(Item that) {
	String str = "";
	if(this.first.isProduct(that)) {
		str = this.first.toString() + this.rest.getSalers(that);
	}else {
		str = this.rest.getSalers(that);
	}
	return str;
}
}
