package lab7_test;

import junit.framework.TestCase;
import ex5.*;

public class Ex5_Test extends TestCase {
	public void testEx5() {
		Product[] productSup = { new Product("Ao", "ao", 123.0, 12), new Product("Quan", "quan", 123.0, 1) };

		Supplier[] suppliers = { new Supplier("Cho neo", productSup) };
		Order[] orders = { new Order("Ao", new Supplier("Cho neo", productSup), "ao", 1),
				new Order("Quan", new Supplier("Cho neo", productSup), "quan", 3) };

		Store store = new Store(suppliers);
		StringBuilder strB = new StringBuilder();
		strB.append(store.toString());

		// add product
		store.addProduct(new Product("Khan", "khan", 12.0, 2));
		assertFalse(strB.toString().equals(store.toString()));
		strB.replace(0, strB.length(), store.toString());
		// quantity of store
		assertEquals(store.productQuantitiesOfSP(), 2);
		// quantity of sup
		assertEquals(store.productQuantitiesOfSup(), 2);
		// placing orders with suppliers, and managing inventory levels.
		store.orderWithSup(orders);
		assertFalse(strB.toString().equals(store.toString()));
	}
}
