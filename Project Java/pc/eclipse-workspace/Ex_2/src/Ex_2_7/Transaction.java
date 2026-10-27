package Ex_2_7;
/**
 * trong Transaction se co 3 thuoc tinh va 2 phuong thuc :
 - String customerName
- int depositAmount
- int maturity

+interest() => tra ve KDL double voi 3 truong hop:
	neu this.depositAmount <= 1000 => return this.depositAmount * 0.04;
	neu this.depositAmount <= 5000 => return this.depositAmount  * 0.045;
	neu this.depositAmount > 5000 => return this.depositAmount  * 0.05;
	
+payBack() => tra ve KDL double voi 4 truong hop:
	neu this.depositAmount == 500 => return this.depositAmount  * 0.0025
	neu 500 < this.depositAmount <=1500 => return (this.depositAmount - 500)*0.005 + (500*0.0025)
	neu 1500 < this.depositAmount <= 2500 => return tnhan = (this.depositAmount-1500)  * 0.0075 + (500*0.0025)+(1000*0.005);
	neu this.depositAmount > 2500 => return  (this.depositAmount-2500)*0.01 + (500*0.0025) + (1000*0.005) + (1000*0.0075) ;

*vidu:
Transaction t1 = new Transaction("Thuy", 6000, 2);
Transaction t2 = new Transaction("Mai", 2500, 1);
Transaction t3 = new Transaction("Nam", 1500, 2);
Transaction t4 = new Transaction("Tien", 500, 2);

 *interest();
	assertEquals(300.0, t1.interest(), 0.001);
	assertEquals(112.5, t2.interest(), 0.001);
	assertEquals(67.5, t3.interest(), 0.001);
	assertEquals(20.0, t4.interest(), 0.001);
 *payBack();
assertEquals(48.75, t1.payback(), 0.001);
assertEquals(13.75, t2.payback(), 0.001);
assertEquals(6.25, t3.payback(), 0.001);
assertEquals(1.25, t4.payback(), 0.001);
 */
public class Transaction {
	 private String customerName;//ten khach hang
	 private int depositAmount;//so tien chuyen vao
	 private int maturity;//ky han
	 //constructor
	public Transaction(String customerName, int depositAmount, int maturity) {
		this.customerName = customerName;
		this.depositAmount = depositAmount;
		this.maturity = maturity;
	}
	//interest()
	public double interest() {
		double  nhan = 0;
		if(this.depositAmount <= 1000) {
			nhan = this.depositAmount * 0.04;
		}else if(this.depositAmount <= 5000) {
			nhan = this.depositAmount * 0.045;
		}else {
			nhan = this.depositAmount * 0.05;
		}
		return nhan;
	}
	//payBack()
	public double payBack() {
		double nhan = 0;
		if(this.depositAmount <= 500) {
			nhan = this.depositAmount  * 0.0025;
		}else if(this.depositAmount > 500 && this.depositAmount <= 1500) {
			nhan = (this.depositAmount - 500)*0.005 + (500*0.0025);
		}else if(this.depositAmount > 1500 && this.depositAmount <= 2500) {
			nhan = (this.depositAmount-1500)  * 0.0075 + (500*0.0025)+(1000*0.005);
		}else if(this.depositAmount > 2500) {
			nhan = (this.depositAmount-2500)*0.01 + (500*0.0025) + (1000*0.005) + (1000*0.0075) ;
		}
		return nhan;
	}
}
