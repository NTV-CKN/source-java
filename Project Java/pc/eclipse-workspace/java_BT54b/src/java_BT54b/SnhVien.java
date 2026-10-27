package java_BT54b;

public class SnhVien implements Comparable<SnhVien> {
	private int maSV;
	private String hoVaTen;
	private double diemTB;
	//constructor
	public SnhVien(int maSV, String hoVaTen, double diemTB) {
		super();
		this.maSV = maSV;
		this.hoVaTen = hoVaTen;
		this.diemTB = diemTB;
	}
	//getter and setter
	public int getMaSV() {
		return maSV;
	}
	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public double getDiemTB() {
		return diemTB;
	}
	public void setDiemTB(double diemTB) {
		this.diemTB = diemTB;
	}
	public String getDiem() {
		String x = "";
    	if(this.diemTB>=0 && this.diemTB<=10) {
				x = x+this.diemTB;
    	}return x;
	}
	@Override
	public int compareTo(SnhVien o) {
	String x = this.getDiem();
	String y = o.getDiem();
	if(x.regionMatches(0, y, 0, 2)) {
		x = x.substring(2);
		y = y.substring(2);
	}
	return x.compareTo(y);
	}
}
