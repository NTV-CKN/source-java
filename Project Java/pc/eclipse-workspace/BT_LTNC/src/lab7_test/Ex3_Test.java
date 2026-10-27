package lab7_test;

import junit.framework.TestCase;
import ex3.*;

public class Ex3_Test extends TestCase {
	public void testEx3() {
		Product[] products = { new Product("Chuoi", "chuoi01", 3.4), new Product("Ao so mi", "somi02", 200.0),
				new Product("Noi chien khong dau", "nckd03", 1000.0) };
		Product productAdd = new Product("Den ngu", "dn04", 120.0);

		ShoppingCart myShoppingCart = new ShoppingCart(products);
		Customer cus = new Customer("Vu", myShoppingCart);

		StringBuilder strB = new StringBuilder();
		strB.append(cus.toString());
		// add
		cus.addProduct(productAdd);
		assertFalse(strB.toString().equals(cus.toString()));
		strB.replace(0, strB.length(), cus.toString());

		// remove
		cus.removeProduct("dn04");
		assertFalse(strB.toString().equals(cus.toString()));
		strB.replace(0, strB.length(), cus.toString());

		// checkout
		assertEquals(cus.checkout(), 1203.4);
	}
}
