
public class Milk {

	
private String name;
private double weight, price;
private Spectification spectification;
private Manufactor manufactor;
private Date producationDate, expiredDate;
public Milk(String name, double weight, double price, Spectification spectification, Manufactor manufactor,
		Date producationDate, Date expiredDate) {
	super();
	this.name = name;
	this.weight = weight;
	this.price = price;
	this.spectification = spectification;
	this.manufactor = manufactor;
	this.producationDate = producationDate;
	this.expiredDate = expiredDate;
}

//sameCompany
public boolean sameCompany(Milk that) {
	return this.manufactor.equals(that.manufactor);
}
//volumn
public double volumn() {
	return Math.PI * Math.pow(spectification.getBaseDiameter(), 2)*spectification.getHeight();
}
//greaterThan
public boolean greaterThan(Milk that) {
	return this.volumn() > that.volumn();
}
//productAfter
public boolean after(Date date) {
	return this.producationDate.after(date);
}
//isExpired
public boolean isExpired(Date date) {
	return this.expiredDate.after(date);
}
//discount
public double discount() {
	Date date1 = new Date(1, 1, 2020);
	Date date2 = new Date(1, 6, 2021);
	double save;
	if(this.producationDate.after(date1) == false) {
		save = this.price - (this.price*0.3);
	}else if(this.producationDate.after(date1) == true && this.after(date2) == false) {
		save = this.price - (this.price*0.1);
	}else {
		save = this.price;
	}
	return save;
}
@Override
public String toString() {
		return "Milk [name=" + name + ", weight=" + weight + ", price=" + price + ", spectification=" + spectification
				+ ", manufactor=" + manufactor + ", producationDate=" + producationDate + ", expiredDate=" + expiredDate
				+ "]";
	}
}
