package de7;

public class Painting extends ArtObject {
	private String loaiTranhSonDau, phongCach;

	@Override
	public String toString() {
		return super.toString() + loaiTranhSonDau + "\t\t" + phongCach + "\n";
	}

	public String getLoaiTranhSonDau() {
		return loaiTranhSonDau;
	}

	public void setLoaiTranhSonDau(String loaiTranhSonDau) {
		this.loaiTranhSonDau = loaiTranhSonDau;
	}

	public Painting(String tenTacGia, String tenTacPham, int year, String loaiTranhSonDau, String phongCach) {
		super(tenTacGia, tenTacPham, year);
		this.loaiTranhSonDau = loaiTranhSonDau;
		this.phongCach = phongCach;
	}

}
