package Ex_6_9;

public class Source extends ARiver{

	public Source(Location location, double length) {
		super(location, length);
	}

	@Override
	public int getNumberSources() {
		return 1;
	}

	@Override
	public boolean checkLocation(Location tht) {
		return this.location.equals(tht);
	}

	@Override
	public double getMilesARiver( )  {
		return this.length;
	}

	@Override
	public boolean checkRadiusLocation(Location that) {
		return this.location.getX() >= that.getX() && this.location.getY()>= that.getY();
	}

	@Override
	public double maxLength() {
		return this.length;
	}

	@Override
	public String getLocation() {
		return this.location.toString();
	}

}
