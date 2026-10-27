package Ex_5_8;

import java.util.Objects;

/**
 * trong Toy co 3 thuoc tinh:
+ String name
+ double price
+ int available
 */
public class Toy {
	public String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double price;
	public int available;
	//constructor
	public Toy(String name, double price, int available) {
		this.name = name;
		this.price = price;
		this.available = available;
	}
	public Toy() {

	}
	@Override
	public String toString() {
		return "Toy [name=" + name + ", price=" + price + ", available=" + available + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Toy other = (Toy) obj;
		return available == other.available && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	public int count() {
		return 1;
	}
}
