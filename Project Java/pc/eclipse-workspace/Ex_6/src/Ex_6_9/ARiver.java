package Ex_6_9;

public abstract class ARiver {
	protected Location location;
	protected double length;
	public ARiver(Location location, double length) {
		super();
		this.location = location;
		this.length = length;
	}
	@Override
	public String toString() {
		return "location=" + location + ", length=" + length;
	}
	public abstract int getNumberSources();
	public abstract boolean checkLocation(Location tht);
	public abstract double getMilesARiver();
	public abstract boolean checkRadiusLocation(Location that);
	public abstract double maxLength();
	public abstract String getLocation();
}
