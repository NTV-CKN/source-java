package ex3;

import java.util.Objects;

public class Product {
	private String nameProduct, productID;
	private double price;

	// constructor
	public Product(String nameProduct, String productID, double price) {
		this.nameProduct = nameProduct;
		this.productID = productID;
		this.price = price;
	}

	// getter and setter
	public double getPrice() {
		return price;
	}


	public String getNameProduct() {
		return nameProduct;
	}

	public String getProductID() {
		return productID;
	}

	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(nameProduct, other.nameProduct)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(productID, other.productID);
	}
	@Override
	public String toString() {
		return "nameProduct: " + nameProduct + ", productID: " + productID + ", price: " + price + "\n";
	}

}
