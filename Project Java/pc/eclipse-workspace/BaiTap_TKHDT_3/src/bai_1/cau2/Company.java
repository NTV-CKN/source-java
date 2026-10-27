package bai_1.cau2;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import bai_1.cau2.strategy.CreditCard;
import bai_1.cau2.strategy.PayPal;

public class Company {
	private List<Customer> customers = new ArrayList<Customer>();
	private List<Product> products = new ArrayList<Product>();
	private List<ShoppingCart> shoppingCarts = new ArrayList<ShoppingCart>();
	private String name;

	public Company(String name) {
		super();
		this.name = name;
	}

	public double saleOnBirthDay(String idCustomer) {
		for (Customer customer : customers) {
			if (customer.getId().equals(idCustomer)) {
				for (ShoppingCart shoppingCart : shoppingCarts) {// Gia su 1 khach hang chi co 1 gio hang
					if (customer.equals(shoppingCart.getCustomer())) {
						double total = shoppingCart.total();
						if (total == 200.000)
							return 0.1;
						if (total == 500.000)
							return 0.15;
						if (total > 1000.000)
							return 0.2;
						else
							return 0;
					}
				}
			}
		}
		return 0;
	}

	public double pay(String idCustomer) {
		for (Customer customer : customers) {
			if (customer.getId().equals(idCustomer)) {
				double sale = 0;
				SimpleDateFormat format = new SimpleDateFormat("dd");

				if (format.format(customer.getDob()).equals(format.format(new Date())))
					sale = saleOnBirthDay(idCustomer);
				System.out.println(sale);
				ShoppingCart shoppingCart = findShoppingCartByIdCustomer(idCustomer);
				double total = 0;
				if (shoppingCart != null)
					total = shoppingCart.total();
				else
					return 0;

				if (customer.getPayment() instanceof CreditCard) {
					if (shoppingCart != null)
						return total + 50.000 - (sale * total);
				} else if (customer.getPayment() instanceof PayPal) {
					if (shoppingCart != null)
						return shoppingCart.total() * 1.1 - (sale * total);
				}
			}
		}
		return 0;
	}

	public void addProduct(Product product) {
		for (Product prodct : products) {
			if (prodct.equals(product))
				return;
		}
		products.add(product);
	}

	public void addCustomer(Customer customer) {
		for (Customer cus : customers) {
			if (cus.equals(customer)) {
				return;
			}
		}
		customers.add(customer);
	}

	public void addShoppingCart(ShoppingCart shoppingCart) {
		for (ShoppingCart shoppingCart2 : shoppingCarts) {
			if (shoppingCart.equals(shoppingCart2)) {
				for (Product product : shoppingCart.getListProducts()) {
					shoppingCart2.addProduct(product);
				}
				return;
			}
		}
		shoppingCarts.add(shoppingCart);
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public List<Product> getProducts() {
		return products;
	}

	public List<ShoppingCart> getShoppingCarts() {
		return shoppingCarts;
	}

	public String getName() {
		return name;
	}

	private ShoppingCart findShoppingCartByIdCustomer(String idCustomer) {
		for (ShoppingCart shopping : shoppingCarts) {
			if (shopping.getCustomer().getId().equals(idCustomer)) {
				return shopping;
			}
		}
		return null;
	}
}
