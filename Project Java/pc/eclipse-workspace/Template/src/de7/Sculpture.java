package de7;

public class Sculpture extends ArtObject {
	@Override
	public String toString() {
		return super.toString() + vatLieu + "\t\t" + height + "\t\t" + weight + "\n";
	}

	public String getVatLieu() {
		return vatLieu;
	}

	public void setVatLieu(String vatLieu) {
		this.vatLieu = vatLieu;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Sculpture(String tenTacGia, String tenTacPham, int year, String vatLieu, int height, int weight) {
		super(tenTacGia, tenTacPham, year);
		this.vatLieu = vatLieu;
		this.height = height;
		this.weight = weight;
	}

	private String vatLieu;
	private int height, weight;
}
