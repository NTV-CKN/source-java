package de5;

public class Account {
	private String id, name;
	private double currentBalance;

	public Account(String id, String name, double current) {
		super();
		this.id = id;
		this.name = name;
		this.currentBalance = current;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	@Override
	public String toString() {
		return id + "\t\t\t" + name + "\t\t\t" + currentBalance + "\t\t\t";
	}

}
