package Ex_7;
/**
 * trong ATaxiVehicle co 3 thuoc tinh va 3 phuong thuc:
#int idNum
#int passengers
#double pricePerMile

+abstract double fare(double mile);
	=>phuong thuc truu tuong tinh tien ve phai tra cho cac loai xe
+lowerThan(double amout, double mile) => tra ve KDL boolean so sanh tien ve phai tra co it hon mot con so kieu double ta dua vao hay khong
	=> return this.fare(double mile) < amout;
+cheaperThan(ATaxiVehicle that, double mile1, double mile2) => tra ve KDL boolean so sanh tien ve cua this co it hon tien ve cua that khong
	=> return this.fare(double mile) < that.fare(double mile);
	
	
 */
public abstract class ATaxiVehicle {
	protected int idNum;//so 
	protected int passengers;//so hanh khach
	protected double pricePerMile;//gia moi dam
	//constructor
	public ATaxiVehicle(int idNum, int passengers, double pricePerMile) {
		this.idNum = idNum;
		this.passengers = passengers;
		this.pricePerMile = pricePerMile;
	}
	//fare
	public abstract double fare(double mile);
	//lowerThan
	public boolean lowerThan(double amout, double mile) {
		return this.fare( mile) < amout;
	}
	//cheaperThan
	public boolean cheaperThan(ATaxiVehicle that, double mile1, double mile2) {
		return this.fare(mile1) < that.fare(mile2);
	}
}
