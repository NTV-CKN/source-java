package Ex_6_9;
public class Confluence extends ARiver{
	private ARiver left;
	private ARiver right;
	//constructor
	public Confluence(Location location, int length , ARiver left, ARiver right) {
		super(location, length);
		this.left = left;
		this.right = right;
	}
	@Override
	public String toString() {
		return "Confluence [left=" + left + ", right=" + right + "]";
	}
	//getNumberSources
	@Override
	public int getNumberSources() {
		return this.location.returnOne() + this.right.getNumberSources() + this.left.getNumberSources();
	}
	@Override
	public boolean checkLocation(Location tht) {
		boolean boo = false;
		if(this.location.equals(tht) == true ||this.left.checkLocation(tht)||this.right.checkLocation(tht)) {
			boo = true;
		}
		return boo;
	}
	@Override
	public double getMilesARiver( ) {
		return this.length + this.left.getMilesARiver( )  + this.right.getMilesARiver( ) ;
	}
	@Override
	public boolean checkRadiusLocation(Location that) {
		return this.location.getX() >= that.getX() && this.location.getY() >= that.getY() || this.right.checkRadiusLocation(that) || this.left.checkRadiusLocation(that);
	}
	@Override
	public double maxLength() {
		double save1 =this.left.maxLength();
		double save2 = this.right.maxLength();
		double max = 0;
		if(this.left.length > this.right.length) {
			max = save1;
		}else {
			max = save2;
		}
		if(this.length > max) {
			max = this.length;
		}
		return max;
	}
	@Override
	public String getLocation() {
		return this.location + "\n"+this.left.location + "\n" + this.right.location;
	}

}
