
public class ConsIListE extends IListE{
private Employee first;
private IListE rest;

	@Override
public String toString() {
	return "ConsIListE [first=" + first + "\n , rest=" + rest + "]";
}

	public ConsIListE(Employee first, IListE rest) {
	super();
	this.first = first;
	this.rest = rest;
}

	@Override
	public int howManyE() {
		// TODO Auto-generated method stub
		return this.first.count()+ this.rest.howManyE();
	}

	

	@Override
	public IListE sortBySalary() {
		// TODO Auto-generated method stub
		return this.rest.sortBySalary().insert(first);
	}
//luong tang dan
	@Override
	public IListE insert(Employee that) {
		// TODO Auto-generated method stub
		IListE ds = null;
		if(this.first.salary() > that.salary()) {
			ds = new ConsIListE(that, this);
		}else {
			ds = new ConsIListE(this.first, this.rest.insert(that));
		}
		return ds;
	}

	@Override
	public IListE addE(Employee ee) {
		// TODO Auto-generated method stub
		return new ConsIListE(ee, this);
	}

	@Override
	public IListE removeStaff() {
		// TODO Auto-generated method stub
		IListE ds = null;
		if(this.first.count() == 0) {
			ds = this.rest.removeStaff();
		}else {
			ds = new ConsIListE(first, this.rest.removeStaff());
		}
		return ds;
	}

	@Override
	public IListE getSalers(Product that) {
		// TODO Auto-generated method stub
		IListE ds = null;
		if(this.first.isProduct(that)) {
			ds = new ConsIListE(first, this.rest.getSalers(that));
		}else {
			ds = this.rest.getSalers(that);
		}
		return ds;
	}

}
