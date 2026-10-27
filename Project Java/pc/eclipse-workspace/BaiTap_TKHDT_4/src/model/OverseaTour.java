package model;

public class OverseaTour extends Tour {
	private String nameCountry;
	private double visaSurtax;

	public OverseaTour(String name, String description, int days, double price, String nameCountry, double visaSurtax) {
		super(name, description, days, price);
		this.nameCountry = nameCountry;
		this.visaSurtax = visaSurtax;
	}

	public String getNameCountry() {
		return nameCountry;
	}

	public double getVisaSurtax() {
		return visaSurtax;
	}

	@Override
	public double getPrice() {
		return super.getPrice() + visaSurtax;
	}
}
