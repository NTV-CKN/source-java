package Ex_5_3_6_1;

public class Empty extends Inventory{

	@Override
	public boolean contains(String name) {
		return false;
	}

	@Override
	public boolean isBelow(double priceThat) {
		return true;
	}

	@Override
	public int howMany() {
		return 0;
	}

	@Override
	public Inventory priceRaise(double rate) {
		return new Empty();
	}

	@Override
	public String toString() {
		return "";
	}

	@Override
	public double averagePrice() {
		return 0;
	}

	@Override
	public void replaceName(Inventory list) {
	
	}

	@Override
	public Inventory eliminate(String toyOfName) {
		return new Empty();
	}

}
