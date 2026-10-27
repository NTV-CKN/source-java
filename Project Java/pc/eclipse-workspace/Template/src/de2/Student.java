package de2;

public class Student implements Comparable<Student>{
	private String maSV, tenSV;
	private MonHoc monHoc;
	private double diemSo;

	public Student(String maSV, String tenSV, MonHoc monHoc, double diemSo) {
		super();
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.monHoc = monHoc;
		this.diemSo = diemSo;
	}

	public String getMaSV() {
		return maSV;
	}

	public String getTenSV() {
		return tenSV;
	}

	public MonHoc getMonHoc() {
		return monHoc;
	}

	public double getDiemSo() {
		return diemSo;
	}

	@Override
	public String toString() {
		return maSV + ", " + tenSV + ", " + monHoc + ", " + diemSo;
	}

	@Override
	public int compareTo(Student o) {
		return this.getTenSV().compareTo(o.getTenSV());
	}

}
