package Ex_6_7;
/**
 * trong EmptyIShopping co 3 thuoctinh duoc Override lai tu IShoppingList
 * 
 */
public class EmptyIShopping extends IShoppingList{

	@Override
	public int howMany() {
		int save = Count.count;
		Count.count=0;
		return save;
	}

	@Override
	public String brandList() {
		return "";
	}

	@Override
	public double highestPrice() {
		return 0;
	}

}
