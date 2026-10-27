package ex5;

import java.util.Objects;

public class Product {
	private String nameProduct, id;
	private double price;
	private int quantity;

	// constructor
	public Product(String nameProduct, String id, double price, int quantity) {
		this.nameProduct = nameProduct;
		this.id = id;
		this.price = price;
		this.quantity = quantity;
	}

	// getter and setter
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity < 0) {
			return;
		}
		this.quantity = quantity;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public String getId() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "nameProduct: " + nameProduct + ", id: " + id + ", price: " + price + ", quantity: " + quantity + "\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id) && Objects.equals(nameProduct, other.nameProduct)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

}
