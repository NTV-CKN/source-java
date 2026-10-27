import java.util.Objects;

public class Produce {
private int id;
public String produceName;
public int available;
public String allocate;
public Produce(int id, String produceName, int available, String allocate) {
	super();
	this.id = id;
	this.produceName = produceName;
	this.available = available;
	this.allocate = allocate;
}
@Override
public String toString() {
	return "Produce [id=" + id + ", produceName=" + produceName + ", available=" + available + ", allocate=" + allocate
			+ "]";
}
@Override
public int hashCode() {
	return Objects.hash(allocate, available, id, produceName);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Produce other = (Produce) obj;
	return Objects.equals(allocate, other.allocate) && available == other.available && id == other.id
			&& Objects.equals(produceName, other.produceName);
}

}
