package ex3;

import java.util.Arrays;

public class ShoppingCart {
	private Product products[] = new Product[1];
	private int indexCurrent = 0;

	// constructor
	public ShoppingCart(Product product) {
		if (this.products[this.products.length - 1] != null) {
			this.products = UpgradeSize.upgS(this.products);
		}
		this.products[indexCurrent++] = product;
	}

	public ShoppingCart(Product[] products) {
		for (int i = 0; i < products.length; i++) {
			if (this.products[this.products.length - 1] != null) {
				this.products = UpgradeSize.upgS(this.products);
			}
			this.products[i] = products[i];
			indexCurrent++;
		}
	}

	// get list product
	public Product getProduct(String productID) {
		for (int i = 0; i < products.length; i++) {
			if (products[i].getProductID().equals(productID)) {
				return products[i];
			}
		}
		return null;
	}

	// add product
	public void addProductToSC(Product product) {
		if (this.products[this.products.length - 1] != null) {
			this.products = UpgradeSize.upgS(this.products);
		}
		this.products[indexCurrent++] = product;
	}

	// remove
	public void removeProducts(String productID) {
		Product proSave = this.getProduct(productID);
		for (int i = 0; i < products.length; i++) {
			if (proSave.equals(this.products[i])) {
				for (int j = i; j < products.length - 1; j++) {
					products[j] = products[j + 1];
				}
				products[products.length - 1] = null;
				indexCurrent--;
				return;
			}
		}
	}

	// checkout
	public double checkoutProducts() {
		double save = 0;
		for (int i = 0; i < products.length; i++) {
			if (products[i] == null) {
				continue;
			}
			save += products[i].getPrice();
		}
		return save;
	}

	@Override
	public String toString() {
		return "products:\n " + Arrays.toString(products);
	}

}
