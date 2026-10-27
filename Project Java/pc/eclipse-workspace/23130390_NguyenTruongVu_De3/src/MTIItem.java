
public class MTIItem extends IItem{

	@Override
	public IItem sortByTitle() {
		// TODO Auto-generated method stub
		return new MTIItem();
	}

	@Override
	public IItem insert(Product that) {
		// TODO Auto-generated method stub
		return new ConsIItem(that, new MTIItem());
	}

	@Override
	public String pL(int s) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String reName() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public boolean checkProduct(Product that) {
		// TODO Auto-generated method stub
		return false;
	}

}
