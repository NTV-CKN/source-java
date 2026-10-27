package ex5;

public class Order {
	private String nameProduct, id;
	private Supplier sup;
	private int quantity;

	// constructor
	public Order(String nameProduct,Supplier sup, String id, int quantity) {
		this.nameProduct = nameProduct;
		this.id = id;
		this.quantity = quantity;
		this.sup = sup;
	}

	// getter
	public String getNameProduct() {
		return nameProduct;
	}

	public String getId() {
		return id;
	}

	public int getQuantity() {
		return quantity;
	}

	public Supplier getSup() {
		return sup;
	}

	@Override
	public String toString() {
		return "nameProduct: " + nameProduct + ", id: " + id + ", quantity: " + quantity + ", supplier: " + sup + "\n";
	}

}
