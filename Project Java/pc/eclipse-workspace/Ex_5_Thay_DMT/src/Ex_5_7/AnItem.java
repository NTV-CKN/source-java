package Ex_5_7;
/**
 * trong AnItem co 3 thuoc tinh va 3 phuong thuc:
#String brandName
#double price
#double gram

+double unitPrice()=> tra ve gia tri don gia voi so tien moi gram voi KDL la double
	=> return this.price / this.gram;
+boolean lowerPrice(double amout) => kiem tra xem so don gia co nho hon mot con so ta dua vao khong
	=> return this.unitPrice() < amout;
+boolean cheaperThan(AnItem that)=> kiem tra xem this co < hon that hay khong
 => this.unitPrice() < that.unitPrice();
 
 	AnItem la lop cha cua IceCream, Coffee, Juice
 	
 	vidu:
 		AnItem ani1_1 = new AnItem("Laura Cafe", 12.900, 200.0);
		AnItem ani1_2 = new AnItem("Ralau cafe", 14.333, 220.0);
		
		AnItem ani2_1 = new AnItem("Cream", 19.0, 58.0);
		AnItem ani2_2 = new AnItem("Cream Deli", 12.999, 23.0);
		
		AnItem ani3_1 = new AnItem("Teri", 22.000, 100.0);
		AnItem ani3_2 = new AnItem("Ferry", 30.000, 120.0);
 
 */
public abstract class AnItem {
	@Override
	public String toString() {
		return "AnItem [brandName=" + brandName + ", price=" + price + ", gram=" + gram + "]";
	}
	protected String brandName;//ten hang
	protected double price;//gia
	protected double gram;//khoi luong theo gram
	//constructor
	public AnItem(String brandName, double price, double gram) {
		this.brandName = brandName;
		this.price = price;
		this.gram = gram;

	}
	//getter and setter
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getGram() {
		return gram;
	}
	public void setGram(double gram) {
		this.gram = gram;
	}
	//unitPrice
	public double unitPrice() {
		return this.price / this.gram;
	}
	//lowerPrice
	public boolean lowerPrice(double amout) {
		return this.unitPrice() < amout;
	}
	//cheaperThan
	public boolean cheaperThan(AnItem that) {
		return this.unitPrice() < that.unitPrice();
	}
}
