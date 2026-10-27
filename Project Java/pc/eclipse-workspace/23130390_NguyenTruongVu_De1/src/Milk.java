
public class Milk {
private String name;
private double weight, price;
private Specification spec;
public Manufactor mF;
private Date producation, expired;
@Override
public String toString() {
	return "Milk [name=" + name + ", weight=" + weight + ", price=" + price + ", spec=" + spec + ", mF=" + mF
			+ ", producation=" + producation + ", expired=" + expired + "]";
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getWeight() {
	return weight;
}
public void setWeight(double weight) {
	this.weight = weight;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public Specification getSpec() {
	return spec;
}
public void setSpec(Specification spec) {
	this.spec = spec;
}
public Manufactor getmF() {
	return mF;
}
public void setmF(Manufactor mF) {
	this.mF = mF;
}
public Date getProducation() {
	return producation;
}
public void setProducation(Date producation) {
	this.producation = producation;
}
public Date getExpired() {
	return expired;
}
public void setExpired(Date expired) {
	this.expired = expired;
}
public Milk(String name, double weight, double price, Specification spec, Manufactor mF, Date producation,
		Date expired) {
	super();
	this.name = name;
	this.weight = weight;
	this.price = price;
	this.spec = spec;
	this.mF = mF;
	this.producation = producation;
	this.expired = expired;
}
//sameCompany
public boolean sameCompany(String name) {
	return this.mF.getCompanyName().equals(name);	
}
//volumn
public double volumn() {
	return Math.PI*this.spec.getBaseDiameter()*this.spec.getBaseDiameter()*this.spec.getHeight();
}
//greaterThan
public boolean greaterThan(Milk that) {
	return this.volumn() > that.volumn();
}
//produceAfter
public boolean produceAfter(Date date) {
	return this.producation.checkProduceAfter(date);
}
//isExpired
public boolean isExpired() {
	return this.expired.checkExpired();
}
//discount
public double discount() {
	double save=0;
	Date date1 = new Date(1, 1, 2020);
	Date date2 = new Date(1, 6, 2021);
	if(date1.checkProduceAfter(this.producation)) {
		save = this.price - (this.price*0.3);
	}else if(date1.checkProduceAfter(this.producation)==false && date2.checkProduceAfter(this.producation)== true) {
		save = this.price - (this.price*0.1);
	}else {
		save = this.price;
	}
	return save;
}
}
