package Ex_5_3;

import java.util.Objects;

/**
 * trong Intersection co 2 thuoc tinh:
-int avenue
-String street
vidu
		Intersection inter1 = new Intersection(12, "Hung Vuong");
		Intersection inter2 = new Intersection(9, "Hoang Hoa Tham");
 */
public class Intersection {
	private int avenue;//dai lo
	private String street;//duong
	//constructor
	public Intersection(int avenue, String street) {
		this.avenue = avenue;
		this.street = street;
	}
	//toString
	@Override
	public String toString() {
		return "avenue: " + avenue + ", street: " + street + ".";
	}
	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Intersection other = (Intersection) obj;
		return avenue == other.avenue && Objects.equals(street, other.street);
	}
	

}
