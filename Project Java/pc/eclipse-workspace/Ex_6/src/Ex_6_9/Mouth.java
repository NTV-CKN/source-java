package Ex_6_9;

public class Mouth {
	private Location location;
	private ARiver river;
	public Mouth(Location location, ARiver river) {
		super();
		this.location = location;
		this.river = river;
	}
	@Override
	public String toString() {
		return "Mouth [location=" + location + ", river=" + river + "]";
	}
	//getNumberSource
	public int getNumberSource() {
		return river.getNumberSources();
	}
	//checkLocationS
	public boolean checkLocationS(Location that) {
		return this.location.equals(that) || this.river.checkLocation(that);
	}
	//getMiles()
	public double getMilesMouth() {
		return this.river.getMilesARiver( ) ;
	}
	//checkRadiusS
	public boolean checkRadiusS(Location that) {
		return this.location.getX() >= that.getX() && this.location.getY() >= that.getY() || this.river.checkRadiusLocation(that);
	}
	//locations
	public String locations() {
		return this.location + "\n"+this.river.getLocation();
	}
}
