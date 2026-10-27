package ex5;

import java.util.Arrays;

public class Store {
	private Product[] storeProducts = new Product[1];
	private Supplier[] suppliers = new Supplier[1];
	private Order orders[] = new Order[1];
	private int iStoreP = 0, iOder = 0;

	// constructor
	public Store(Supplier[] suppliers) {
		for (int i = 0; i < suppliers.length; i++) {
			if (this.suppliers[this.suppliers.length - 1] != null) {
				this.suppliers = (Supplier[]) UpgradeSize.upgS(this.suppliers);
			}
			this.suppliers[i] = suppliers[i];
		}
	}

	// add new product
	public void addProduct(Product product) {
		if (this.storeProducts[this.storeProducts.length - 1] != null) {
			this.storeProducts = (Product[]) UpgradeSize.upgS(this.storeProducts);
		}
		this.storeProducts[iStoreP++] = product;
	}

	// update product quantities
	public int productQuantitiesOfSP() {
		int save = 1;
		for (int i = 0; i < storeProducts.length; i++) {
			if (this.storeProducts[i] != null) {
				save++;
			}
		}
		return save;
	}

	public int productQuantitiesOfSup() {
		int save = 1;
		for (int i = 0; i < suppliers.length; i++) {
			if (suppliers[i] != null) {
				save++;
			}
		}
		return save;
	}

	// managing inventory levels
	public boolean managingInventory(Supplier sup, String productID, int amount) {
		Product productSave = sup.getProduct(productID);
		if (productSave == null)
			return false;
		if (productSave.getQuantity() > amount)
			return true;
		return false;
	}

	// update sup
	public void updateQuantities(int index, int amount, String productID) {
		this.suppliers[index].updateQuantitiesOfPro(productID, amount);
	}

	// add order
	public void addOrder(Order[] orders) {
		for (int i = 0; i < orders.length; i++) {
			if (this.orders[this.orders.length - 1] != null) {
				this.orders = (Order[]) UpgradeSize.upgS(this.orders);
			}
			this.orders[i] = orders[i];
			iOder++;
		}
	}

	// placing orders with suppliers
	public void orderWithSup(Order[] orders) {
		this.addOrder(orders);

		for (int i = 0; i < this.suppliers.length; i++) {
			if (this.suppliers[i] == null) {
				break;
			}
			for (int j = 0; j < this.orders.length; j++) {
				if (this.orders[i] == null) {
					break;
				}
				if (this.suppliers[i].equals(this.orders[j].getSup())) {
					if (this.managingInventory(this.suppliers[i], this.orders[j].getId(), this.orders[j].getQuantity()))
						this.updateQuantities(i, this.orders[j].getQuantity(), this.orders[j].getId());
					break;
				}
			}
		}
	}

	@Override
	public String toString() {
		return "suppliers:\n" + Arrays.toString(suppliers) + "\norders:\n" + Arrays.toString(orders) + "\n"
				+ "Store Product:\n" + Arrays.toString(storeProducts);
	}

}
