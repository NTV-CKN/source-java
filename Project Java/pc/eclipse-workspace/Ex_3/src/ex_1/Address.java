package ex_1;
/**
 * trong address co 3 thuoc tinh:
 -String houseName
 -String streetName
 -String aCity
 */
public class Address {
	 private String houseName;
	 private String streetName;
	 private String aCity;
	//constructor
	public Address(String houseName, String streetName, String aCity) {
		this.houseName = houseName;
		this.streetName = streetName;
		this.aCity = aCity;
	}
	//getter and setter
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getaCity() {
		return aCity;
	}
	public void setaCity(String aCity) {
		this.aCity = aCity;
	}
}
