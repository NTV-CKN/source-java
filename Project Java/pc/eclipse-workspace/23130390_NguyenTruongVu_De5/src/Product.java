import java.util.Objects;

public class Product {
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public String getNameProduct() {
		return nameProduct;
	}
	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}
	public String getAllocate() {
		return allocate;
	}
	public void setAllocate(String allocate) {
		this.allocate = allocate;
	}
private int id, available;
private String nameProduct, allocate;
public Product(int id, int available, String nameProduct, String allocate) {
	super();
	this.id = id;
	this.available = available;
	this.nameProduct = nameProduct;
	this.allocate = allocate;
}
@Override
public int hashCode() {
	return Objects.hash(allocate, available, id, nameProduct);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Product other = (Product) obj;
	return Objects.equals(allocate, other.allocate) && available == other.available && id == other.id
			&& Objects.equals(nameProduct, other.nameProduct);
}
@Override
public String toString() {
	return "Product [id=" + id + ", available=" + available + ", nameProduct=" + nameProduct + ", allocate=" + allocate
			+ "]";
}

}
