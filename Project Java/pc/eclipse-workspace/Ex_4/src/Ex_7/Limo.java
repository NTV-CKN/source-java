package Ex_7;
/**
 * trong Limo co 1 thuoc tinh va co 1 phuong thuc duoc Override lai tu ATaxiVehicle:
-double minRental

+fare(double mile)

 */
public class Limo extends ATaxiVehicle{
	private double minRental;//tien thue toi thieu
	//constructor
	public Limo(int idNum, int passengers, double pricePerMile, double minRental) {
		super(idNum, passengers, pricePerMile);
		this.minRental = minRental;
	}
	@Override
	public double fare(double mile) {
		double save;
		if(this.pricePerMile * mile <= this.minRental) {
			save = this.minRental;
		}else {
			save = this.pricePerMile * mile;
		}
		return save;
	}

}
