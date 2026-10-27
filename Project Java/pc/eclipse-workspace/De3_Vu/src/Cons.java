
public class Cons extends DanhSach{
	public Cons(Vehicle v, DanhSach ds) {
		super();
		this.v = v;
		this.ds = ds;
	}
	private Vehicle v;
	private DanhSach ds;
	private Vehicle vc;
	@Override
	public boolean isDriver(Vehicle v) {
		this.vc = v;
		boolean boo = this.v.equals(vc);
		if(boo == false) {
		boo =	this.ds.isDriver(vc);
		}else {
			boo = true;
		}
		return boo;
	}
	//
//	@Override
//	public boolean getDriver(Vehicle that) {
//		boo str;
//		if(this.isDriver(that)== true) {
//			str = super.toString();
//		}else {
//			str = "";
//		}
//		return str;
//	}
}
