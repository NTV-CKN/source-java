import java.text.NumberFormat;
import java.util.Locale;
/*
 * ta co 4 thuoc tinh thuoc private trong Automobile:
 * String model
 * String price
 * double mileage
 *boolean used
 *vidu:
 *	new Automobile("Short", 1230000, 6.5, false);
 */
public class Automobile {
	 private String model;//mau ma
	 private int price;//gia ca tinh theo dollar
	 private double mileage;//so dam di duoc tren gallon
	 private boolean used;//tinh trang
	 //constructor
public Automobile(String model, int price, double mileage, boolean used) {
	this.model = model;
	this.price = price;
	this.mileage = mileage;
	this.used = used;
	 }
	//format price
//	 public String format(int price) {
//		 Locale locale = new Locale("en", "US");
//		 NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
//		 return nf.format(price);
//	 }
}
