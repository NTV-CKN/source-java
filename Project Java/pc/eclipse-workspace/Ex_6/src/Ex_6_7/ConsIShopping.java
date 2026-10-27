package Ex_6_7;
/**
 * trong ConsIShopping co 2 thuoc tinh va 3 thuoc tinh duoc Override tu IShoppingList
private AnItem first
private IShoppingList rest
 */
public class ConsIShopping extends IShoppingList{
	private AnItem first;
	private IShoppingList rest;
	//constructor
	public ConsIShopping(AnItem first, IShoppingList rest) {
		super();
		this.first = first;
		this.rest = rest;
	}
	@Override
	public String toString() {
		return "ConsIShopping [first=" + first + ", rest=" + rest + "]";
	}
	@Override
	public int howMany() {
		Count.count();
		return	 this.rest.howMany(); 
	}
	@Override
	public String brandList() {
		return this.first.getBrandName() + "\n" + this.rest.brandList();
	}
	@Override
	public double highestPrice() {
		double saveRest = this.rest.highestPrice();
		double saveFirst = this.first.price;
		double max = 0;
		if(saveFirst < saveRest) {
			max = saveRest;
		}else {
			max = saveFirst;
		}
		return max;
	}
	
}
