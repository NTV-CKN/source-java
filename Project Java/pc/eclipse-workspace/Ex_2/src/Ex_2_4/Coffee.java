package Ex_2_4;
/**
 * trong Coffee se co 3 thuoc tinh va 2 phuong thuc:
- String kind
- double price
- double weight

+cost() => tra ve KDL double, return this.price * this.weight
+pay() =>tra ve KDL double va co 3 truong hop:
	1. return this.cost neu < 5000 pounds
	2. return this.cost() * 0.1 neu >= 5000 && < 20000 pounds
	3. return this.cost() * 0.25 neu >= 20000 pounds
	*vidu:
	*Coffee cf_1 = new Coffee("Chon", 2000, 2.3);
	*Coffee cf_2 = new Coffee("Muoi", 2000, 23.4);
	*
	*cf_1.pay(); => 4600
	*cf_2.pay();=>35100
	*
	*cf_1.cost(); => 4600
	*cd_2.cost(); => 46800
 */
public class Coffee {
	private String kind;//loai cafe
	private double price;//gia cafe
	private double weight;//khoi luong
	//constructor
	public Coffee(String kind, double price, double weight) {
		this.kind = kind;
		this.price = price;
		this.weight = weight;
	}
	//cost
	public double cost() {
		return this.price * this.weight;
	}
	//pay
	public double pay() {
		double pay = this.cost();
		if(pay < 5000) {
			return pay;
		}else if(pay >= 5000 && pay<20000) {
			return pay - (pay * 0.1);
		}else {
			return pay - (pay * 0.25);
		}
	}
}
