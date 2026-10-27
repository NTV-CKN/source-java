package de5;

public class CheckingAccount extends Account {
	public double getMinBalance() {
		return minBalance;
	}



	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}



	private double minBalance;



	public CheckingAccount(String id, String name, double current, double minBalance) {
		super(id, name, current);
		this.minBalance = minBalance;
	}



	@Override
	public String toString() {
		return super.toString() + minBalance + "\n";
	}

}
