package ex3;

public class UpgradeSize {
	public static Product[] upgS(Product[] list) {
		Product[] products = new Product[list.length + 5];
		for (int i = 0; i < list.length; i++) {
			products[i] = list[i];
		}
		return products;
	}
}
