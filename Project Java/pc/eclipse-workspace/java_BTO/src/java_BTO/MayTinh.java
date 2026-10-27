package java_BTO;

public class MayTinh {
private HangSX hsx;
private NgaySX nsx;
private double giaBan;
private int thoiGianBH;
public MayTinh(HangSX hsx, NgaySX nsx, double giaBan, int thoiGianBH) {
	this.hsx = hsx;
	this.nsx = nsx;
	this.giaBan = giaBan;
	this.thoiGianBH = thoiGianBH;
}
public HangSX getHsx() {
	return hsx;
}
public void setHsx(HangSX hsx) {
	this.hsx = hsx;
}
public NgaySX getNsx() {
	return nsx;
}
public void setNsx(NgaySX nsx) {
	this.nsx = nsx;
}
public double getGiaBan() {
	return giaBan;
}
public void setGiaBan(double giaBan) {
	this.giaBan = giaBan;
}
public int getThoiGianBH() {
	return thoiGianBH;
}
public void setThoiGianBH(int thoiGianBH) {
	this.thoiGianBH = thoiGianBH;
}
//boolean
public boolean soSanh(MayTinh giaKhac) {
	return this.giaBan > giaKhac.getGiaBan();
}


}
