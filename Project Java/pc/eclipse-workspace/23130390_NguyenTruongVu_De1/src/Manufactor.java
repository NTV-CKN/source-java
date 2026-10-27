import java.util.Objects;

public class Manufactor {
@Override
	public int hashCode() {
		return Objects.hash(companyName, country);
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
		return Objects.equals(companyName, other.companyName) && Objects.equals(country, other.country);
	}

private String companyName, country;

@Override
public String toString() {
	return "Manufactor [companyName=" + companyName + ", country=" + country + "]";
}

public String getCompanyName() {
	return companyName;
}

public void setCompanyName(String companyName) {
	this.companyName = companyName;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public Manufactor(String companyName, String country) {
	super();
	this.companyName = companyName;
	this.country = country;
}

}
