package java_BT45;

public abstract class PhuongTienDiChuyen {
protected String loaiPhuongTien;
protected HangSX hsx;
public PhuongTienDiChuyen(String loaiPhuongTien, HangSX hsx) {
	super();
	this.loaiPhuongTien = loaiPhuongTien;
	this.hsx = hsx;
}
public String getLoaiPhuongTien() {
	return loaiPhuongTien;
}
public void setLoaiPhuongTien(String loaiPhuongTien) {
	this.loaiPhuongTien = loaiPhuongTien;
}
public HangSX getHsx() {
	return hsx;
}
public void setHsx(HangSX hsx) {
	this.hsx = hsx;
}
public String layTenHangSX() {
	return this.hsx.getTenHangSX();
}
public void batDau() {
	System.out.println("Bat dau burbur!");
}
public void tangToc() {
	System.out.println("un un");
}
public void dungLai() {
	System.out.println("dung lai qua nguy hiem!");
}
public abstract double layVanToc();
}
