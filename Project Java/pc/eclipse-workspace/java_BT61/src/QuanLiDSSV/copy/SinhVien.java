package QuanLiDSSV.copy;

import java.util.Objects;

public class SinhVien implements Comparable<SinhVien>{
private String maSV;
private String fullName;
private int namSinh;
private double diemTB;

public SinhVien(String maSV, String fullName, int namSinh, double diemTB) {
	this.maSV = maSV;
	this.fullName = fullName;
	this.namSinh = namSinh;
	this.diemTB = diemTB;
}
public SinhVien(String maSVv) {
	this.maSV = maSVv;
}
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
@Override
public String toString() {
	return "SinhVien [maSV=" + maSV + ", fullName=" + fullName + ", namSinh=" + namSinh + ", diemTB=" + diemTB + "]";
}
@Override
public int compareTo(SinhVien o) {
	return this.maSV.compareTo(o.maSV);
}
@Override
public int hashCode() {
	return Objects.hash(maSV);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	SinhVien other = (SinhVien) obj;
	return Objects.equals(maSV, other.maSV);
}

}
