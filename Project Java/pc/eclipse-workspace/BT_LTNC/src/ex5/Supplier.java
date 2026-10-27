package ex5;

import java.util.Arrays;
import java.util.Objects;

public class Supplier {
	private String nameSupplier;
	private Product[] products = new Product[1];

	// constructor
	public Supplier(String nameSupplier, Product[] products) {
		this.nameSupplier = nameSupplier;

		for (int i = 0; i < products.length; i++) {
			if (this.products[this.products.length - 1] != null) {
				this.products = (Product[]) UpgradeSize.upgS(this.products);
			}
			this.products[i] = products[i];
		}
	}

	// get product
	public Product getProduct(String productID) {
		for (int i = 0; i < products.length; i++) {
			if (this.products[i].getId().equals(productID)) {
				return this.products[i];
			}
		}
		return null;
	}

	// update quantities of products
	public void updateQuantitiesOfPro(String productID, int amount) {
		for (int i = 0; i < products.length; i++) {
			if (this.products[i].getId().equals(productID)) {
				this.products[i].setQuantity(this.products[i].getQuantity() - amount);
				break;
			}
		}
	}

	@Override
	public String toString() {
		return "nameSupplier: " + nameSupplier + ", products:\n" + Arrays.toString(products);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supplier other = (Supplier) obj;
		return Objects.equals(nameSupplier, other.nameSupplier) && Arrays.equals(products, other.products);
	}

}
