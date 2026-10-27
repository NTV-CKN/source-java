package ex3;

public class Customer {
	private String nameCus;
	private ShoppingCart myShoppingCart;
	private double totalPrice = 0;

	// constructor
	public Customer(String name, ShoppingCart sh) {
		this.nameCus = name;
		this.myShoppingCart = sh;
	}

	// add
	public void addProduct(Product product) {
		this.myShoppingCart.addProductToSC(product);
	}

	// remove
	public void removeProduct(String productID) {
		this.myShoppingCart.removeProducts(productID);
	}

	// proceed checkout
	public double checkout() {
		this.totalPrice = this.myShoppingCart.checkoutProducts();
		return this.totalPrice;
	}

	@Override
	public String toString() {
		return "nameCus: " + nameCus + ", myShoppingCart:\n" + myShoppingCart + ", totalPrice: " + totalPrice;
	}

}
