
public class MTItem extends IItem{

	@Override
	public boolean checkProduct(Item that) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IItem sortByTitle() {
		// TODO Auto-generated method stub
		return new MTItem();
	}

	@Override
	public IItem insert(Item that) {
		// TODO Auto-generated method stub
		return new ConsItem(that, new MTItem());
	}

	@Override
	public int total(String name) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public String pL(String name) {
		// TODO Auto-generated method stub
		return "";
	}

}
