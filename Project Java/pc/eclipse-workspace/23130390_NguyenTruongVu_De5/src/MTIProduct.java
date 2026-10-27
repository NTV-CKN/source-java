
public class MTIProduct extends IProduct{

	@Override
	public IProduct sortByTitle() {
		// TODO Auto-generated method stub
		return new MTIProduct();
	}

	@Override
	public IProduct insert(Product that) {
		// TODO Auto-generated method stub
		return new ConsIProduct(that, new MTIProduct());
	}

	@Override
	public int totalSameProduct(String allowcate) {
		// TODO Auto-generated method stub
		return 0;
	}

	

	@Override
	public String sameAvailable() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public boolean checkAvailable(Product that) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkProduct(Product that) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IProduct pL(String allowcate) {
		// TODO Auto-generated method stub
		
		return new MTIProduct();
	}

}
