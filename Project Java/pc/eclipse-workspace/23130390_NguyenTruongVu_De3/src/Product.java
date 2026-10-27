import java.util.Objects;

public class Product {
@Override
	public int hashCode() {
		return Objects.hash(available, id, name);
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
		return available == other.available && id == other.id && Objects.equals(name, other.name);
	}
private int id;
private String name;
private int available;
public Product(int id, String name, int available) {
	super();
	this.id = id;
	this.name = name;
	this.available = available;
}
@Override
public String toString() {
	return "Product [id=" + id + ", name=" + name + ", available=" + available + "]"+"\n";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAvailable() {
	return available;
}
public void setAvailable(int available) {
	this.available = available;
}

}
