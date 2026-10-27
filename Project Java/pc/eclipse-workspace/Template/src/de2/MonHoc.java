package de2;

public class MonHoc {
	private String maMh, tenMH;
	private int soTinChi;
	public MonHoc(String maMh, String tenMH, int soTinChi) {
		super();
		this.maMh = maMh;
		this.tenMH = tenMH;
		this.soTinChi = soTinChi;
	}
	@Override
	public String toString() {
		return maMh + ", " + tenMH + ", " + soTinChi;
	}
	public String getMaMh() {
		return maMh;
	}
	public String getTenMH() {
		return tenMH;
	}
	public int getSoTinChi() {
		return soTinChi;
	}
	
}
