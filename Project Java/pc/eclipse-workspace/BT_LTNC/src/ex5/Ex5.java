package ex5;

public class Ex5 {
	public static void main(String[] args) {
		Product[] productSup = { new Product("Ao", "ao", 123.0, 12), new Product("Quan", "quan", 123.0, 1) };
		Product[] productStore = { new Product("Giay", "giay", 23.0, 20), new Product("Mu", "mu", 1234.0, 3) };

		Supplier[] suppliers = { new Supplier("Cho neo", productSup) };
		Order[] orders = { new Order("Ao", new Supplier("Cho neo", productSup), "ao", 1),
				new Order("Quan", new Supplier("Cho neo", productSup), "quan", 3) };

		Store store = new Store(suppliers);

		System.out.println(store);
		// add product
		System.out.println("=============================================");
		for (Product p : productStore) {
			store.addProduct(p);
		}
		store.addProduct(new Product("Khan", "khan", 12.0, 2));
		System.out.println(store);
		// quantity of store
		System.out.println("=============================================");
		System.out.println(store.productQuantitiesOfSP());
		// quantity of sup
		System.out.println(store.productQuantitiesOfSup());
		// placing orders with suppliers, and managing inventory levels.
		System.out.println("=============================================");
		store.orderWithSup(orders);
		System.out.println(store);
	}
}
