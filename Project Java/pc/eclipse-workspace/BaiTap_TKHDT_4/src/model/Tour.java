package model;

public abstract class Tour {
	private String name, description;
	private int days;
	private double price;

	public Tour(String name, String description, int days, double price) {
		super();
		this.name = name;
		this.description = description;
		this.days = days;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getDays() {
		return days;
	}

	public double getPrice() {
		return price;
	}
}
