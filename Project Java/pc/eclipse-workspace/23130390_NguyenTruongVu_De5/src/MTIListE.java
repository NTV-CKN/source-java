
public class MTIListE extends IListE{

	@Override
	public int howManyE() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public IListE sortBySalary() {
		// TODO Auto-generated method stub
		return new MTIListE();
	}

	@Override
	public IListE insert(Employee that) {
		// TODO Auto-generated method stub
		return new ConsIListE(that, new MTIListE());
	}

	@Override
	public IListE addE(Employee ee) {
		// TODO Auto-generated method stub
		return new MTIListE();
	}

	@Override
	public IListE removeStaff() {
		// TODO Auto-generated method stub
		return new MTIListE();
	}


	@Override
	public IListE getSalers(Product that) {
		// TODO Auto-generated method stub
		return new MTIListE();
	}

}
