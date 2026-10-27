import java.util.Objects;

public class Item {
@Override
	public int hashCode() {
		return Objects.hash(available, id, manufactor, produceName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return available == other.available && id == other.id && Objects.equals(manufactor, other.manufactor)
				&& Objects.equals(produceName, other.produceName);
	}
private int id;
public String produceName, manufactor;
private int available;
@Override
public String toString() {
	return "Item [id=" + id + ", produceName=" + produceName + ", manufactor=" + manufactor + ", available=" + available
			+ "]";
}
public Item(int id, String produceName, String manufactor, int available) {
	super();
	this.id = id;
	this.produceName = produceName;
	this.manufactor = manufactor;
	this.available = available;
}
}
