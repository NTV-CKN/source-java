import java.util.Objects;

public class Manufactor {
String brandName;
String country;
public Manufactor(String brandName, String country) {
	super();
	this.brandName = brandName;
	this.country = country;
}
@Override
public int hashCode() {
	return Objects.hash(brandName, country);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Manufactor other = (Manufactor) obj;
	return Objects.equals(brandName, other.brandName) && Objects.equals(country, other.country);
}
@Override
public String toString() {
	return "Manufactor [brandName=" + brandName + ", country=" + country + "]";
}

}
