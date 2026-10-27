package Ex_2_2;
/**
 * trong MovieTheater co 4 thuoc tinh va 1 phuong thuc:
*- double performanceCost
*- double serviceCharge
*- double ticketPrice
	*double totalProfit(int customers) => tra ve KDL double va tham so dau vao la so luong khach hang
	*voi cau truc: customers * 5 - (20 + customers*0.5)
	*vidu: new MovieTheater(20, 0.5, 5).totalProfit(40)
	*=> return 160
 */
public class MovieTheater {
	private double performanceCost;//tien trinh dien
	private double serviceCharge;//phi dich vu
	private double ticketPrice;//gia ve
	//constructor
	public MovieTheater(double performanceCost, double serviceCharge, double ticketPrice) {
		this.performanceCost = performanceCost;
		this.serviceCharge = serviceCharge;
		this.ticketPrice = ticketPrice;
	}
	//totalProfit
	public double totalProfit(int customers) {
		return this.ticketPrice * customers - (this.performanceCost + this.serviceCharge*customers);
	}
}
