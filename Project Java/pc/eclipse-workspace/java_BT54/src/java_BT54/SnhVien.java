package java_BT54;

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
//override snhvien
//So sanh hoVaTen
public String getTen() {
	int luu ;
	String  s = this.hoVaTen;
	s.trim();
	if(s.indexOf(" ") >= 0) {
       luu = s.lastIndexOf(" ");
       return s.substring(luu + 1);
	}else {
		return s.substring(0);
	}
	
}
@Override
public int compareTo(SnhVien o) {
    String x = this.getTen();
    String y =  o.getTen();
    return x.compareTo(y);
}



}
