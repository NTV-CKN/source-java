package Ex_7;
/**
 * trong Van co 1 thuoc tinh va co 1 phuong thuc duoc Override lai tu ATaxiVehicle:
-boolean access;

+fare(double mile)
 */
public class Van extends ATaxiVehicle{	
	private boolean access;
	//constructor
	public Van(int idNum, int passengers, double pricePerMile, boolean a) {
		super(idNum, passengers, pricePerMile);
		this.access = a;
	}
	@Override
	public double fare(double mile) {
		return this.pricePerMile * mile + this.passengers;
	}
	
}
