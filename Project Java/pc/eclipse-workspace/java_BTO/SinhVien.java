package QuanLiDSSV;

public class SinhVien implements Comparable<SinhVien> {
private String maSV;
private String fullName;
private int namSinh;
private double diemTB;
//constructor
public SinhVien(String maSV, String fullName, int namSinh, double diemTB) {
	super();
	this.maSV = maSV;
	this.fullName = fullName;
	this.namSinh = namSinh;
	this.diemTB = diemTB;
}
//getter setter
public String getMaSV() {
	return maSV;
}
public void setMaSV(String maSV) {
	this.maSV = maSV;
}
public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public int getNamSinh() {
	return namSinh;
}
public void setNamSinh(int namSinh) {
	this.namSinh = namSinh;
}
public double getDiemTB() {
	return diemTB;
}
public void setDiemTB(double diemTB) {
	this.diemTB = diemTB;
}
//toString
@Override
public String toString() {
	return "Ma sinh vien " + maSV + ", ho va ten " + fullName + ", nam sinh " + namSinh + ", diem trung bih " + diemTB ;
}
@Override
public int compareTo(SinhVien o) {
	return this.maSV.compareTo(o.maSV);
}

}
