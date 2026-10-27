package de7;

public class ArtObject implements Comparable<ArtObject> {
	private String tenTacGia, tenTacPham;
	private int year;

	public String getTenTacGia() {
		return tenTacGia;
	}

	public String getTenTacPham() {
		return tenTacPham;
	}

	public int getYear() {
		return year;
	}

	public ArtObject(String tenTacGia, String tenTacPham, int year) {
		super();
		this.tenTacGia = tenTacGia;
		this.tenTacPham = tenTacPham;
		this.year = year;
	}

	@Override
	public String toString() {
		return tenTacGia + "\t\t" + tenTacPham + "\t\t" + year + "\t\t";
	}

	@Override
	public int compareTo(ArtObject o) {
		return this.getTenTacPham().compareTo(o.getTenTacPham());
	}

}
