package Ex_2_5;
/**
 * trong JetFuel co 3 thuoc tinh va 2 phuong thuc:
 - int quantitySold
- int basePrice
- String qualityLevel

+totalCost() => tra ve KDL int, return this.basePrice * this.quantitySold;
+discountSold() => tra ve KDL double, co 2 truong hop:
 	neu quantitySold > 100000 gallons thi return this.totalCost() - (this.totalCost() * 0.1);
 	neu quantitySold <= 100000 gallons thi return this.totalCost();
 	
 	*JetFuel jf_1 = new JetFuel(150000, 200, "High");
 	*JetFuel jf_2 = new JetFuel(100000, 200, "Normal");
 	*
 	*jf_1.totalCost();=> 30000000
 	*jf_2.totalCost();=> 20000000
 	*
 	*jf_1.discountSold();=> 27000000.0
 	*jf_2.discountSold();=> 20000000.0
 */
public class JetFuel {
	 private int quantitySold;//so luong ban ra
	 private int basePrice;//gia ban
	 private String qualityLevel;//chat luong
	 //constructor
	public JetFuel(int quantitySold, int basePrice, String qualityLevel) {
		this.quantitySold = quantitySold;
		this.basePrice = basePrice;
		this.qualityLevel = qualityLevel;
	}
	//totalCost
	public int totalCost() {
		return this.quantitySold * this.basePrice;
	}
	//discountSold
	public double discountSold() {
		double discount;
		if(this.quantitySold > 100000) {
			discount =  this.totalCost() - (this.totalCost() * 0.1);
		}else {
			discount = this.totalCost();
		}
		return discount;
	}
}
