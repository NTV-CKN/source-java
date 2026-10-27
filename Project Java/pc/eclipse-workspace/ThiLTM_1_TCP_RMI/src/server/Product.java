package server;

public class Product {
	int idsp;
	String name;
	int count;
	double price;
	public Product(int idsp, String name, int count, double price) {
		super();
		this.idsp = idsp;
		this.name = name;
		this.count = count;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [idsp=" + idsp + ", name=" + name + ", count=" + count + ", price=" + price + "]";
	}
	
}
