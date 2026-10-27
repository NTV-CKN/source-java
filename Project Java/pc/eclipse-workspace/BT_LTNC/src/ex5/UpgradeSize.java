package ex5;

public class UpgradeSize {
	public static Object[] upgS(Object[] obj) {
		if (obj instanceof Product[]) {
			Product[] products = new Product[obj.length + 5];
			for (int i = 0; i < obj.length; i++) {
				products[i] = (Product) obj[i];
			}
			return products;
		} else if (obj instanceof Order[]) {
			Order[] orders = new Order[obj.length + 5];
			for (int i = 0; i < obj.length; i++) {
				orders[i] = (Order) obj[i];
			}
			return orders;
		} else if (obj instanceof Supplier[]) {
			Supplier[] suppliers = new Supplier[obj.length + 5];
			for (int i = 0; i < obj.length; i++) {
				suppliers[i] = (Supplier) obj[i];
			}
			return suppliers;
		}
		return null;
	}
}
