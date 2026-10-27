package Ex_7;
/**
 * trong Cab khong co thuoc tinh va co 1 phuong thuc duoc Override lai tu ATaxiVehicle:
+fare(double mile)
 */
public class Cab extends ATaxiVehicle{

	//constructor
	public Cab(int idNum, int passengers, double pricePerMile) {
		super(idNum, passengers, pricePerMile);
	}
	@Override
	public double fare(double mile) {
		return this.pricePerMile * mile;
	}

}
