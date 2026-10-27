import java.util.Objects;

public class Product {
private int id;
private String productName;
private int soLuongHienCo;
public Product(int id, String productName, int soLuongHienCo) {
	super();
	this.id = id;
	this.productName = productName;
	this.soLuongHienCo = soLuongHienCo;
}
//set get
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public int getSoLuongHienCo() {
	return soLuongHienCo;
}
public void setSoLuongHienCo(int soLuongHienCo) {
	this.soLuongHienCo = soLuongHienCo;
}
@Override
public int hashCode() {
	return Objects.hash(id, productName, soLuongHienCo);
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
	return id == other.id && Objects.equals(productName, other.productName);
}
}
