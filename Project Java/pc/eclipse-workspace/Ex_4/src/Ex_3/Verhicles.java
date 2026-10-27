package Ex_3;
/**
 * trong Verhicles co 2 thuoc tinh:
 #String model
 #String brand
 
 vidu 
		Verhicles b = new Bus("#hds", "NhaTr", "#123", 18);
		Verhicles lm = new Limo("#hdb", "Celes" , 2005, 18);
		Verhicles car = new Car("#hdc", "KIA", 4, true);
		Verhicles sw = new Subway("#hdf", "AK" , 5.3, 100);

		assertEquals(b.toString(), "#hds, NhaTr, #123, 18");
		assertEquals(lm.toString(), "#hdb, Celes, 18, 2005");
		assertEquals(car.toString(), "#hdc, KIA, 4, true");
		assertEquals(sw.toString(), "#hdf, AK, 5.3, 100.0");
 */
public abstract class Verhicles {
	protected String model;//mau ma
	protected String brand;//hang
	//constructor
	public Verhicles(String model, String brand) {
		super();
		this.model = model;
		this.brand = brand;
	}
	//getter and setter
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	//toString
	@Override
	public String toString() {
		return this.getModel() + ", "+this.getBrand() + ", ";
	}
}
