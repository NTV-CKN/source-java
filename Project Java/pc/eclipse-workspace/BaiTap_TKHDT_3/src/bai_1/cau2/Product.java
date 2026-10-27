package bai_1.cau2;

import java.util.Objects;

public class Product {
	private String code, name;
	private double price;

	public Product(String code, String name, double price) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, name, price);
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
		return Objects.equals(code, other.code) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

}
