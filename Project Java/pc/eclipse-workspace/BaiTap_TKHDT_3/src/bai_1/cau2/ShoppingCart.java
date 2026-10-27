package bai_1.cau2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ShoppingCart {
	private Customer customer;
	private List<Product> listProducts = new ArrayList<Product>();

	public ShoppingCart(Customer customer) {
		super();
		this.customer = customer;
	}

	public void addProduct(Product product) {
		if (product != null)
			listProducts.add(product);
	}

	public void removeProduct(Product product) {
		listProducts.remove(product);
	}

	public double total() {
		Iterator<Product> iterator = listProducts.iterator();
		double sum = 0;
		while (iterator.hasNext()) {
			sum += iterator.next().getPrice();
		}
		return sum;
	}

	public Customer getCustomer() {
		return customer;
	}

	public List<Product> getListProducts() {
		return listProducts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer, listProducts);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShoppingCart other = (ShoppingCart) obj;
		return Objects.equals(customer, other.customer) && Objects.equals(listProducts, other.listProducts);
	}
}
