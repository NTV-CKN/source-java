package de5;

public class SavingAccount extends Account {
	private double interestRate;



	public double getInterestRate() {
		return interestRate;
	}



	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}



	public SavingAccount(String id, String name, double current, double interestRate) {
		super(id, name, current);
		this.interestRate = interestRate;
	}



	@Override
	public String toString() {
		return super.toString() + interestRate + "\n";
	}

}
