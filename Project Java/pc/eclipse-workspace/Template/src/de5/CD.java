package de5;

public class CD extends Account {
	private double interestRate;
	private String dateExpire;


	public double getInterestRate() {
		return interestRate;
	}


	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}


	public String getDateExpire() {
		return dateExpire;
	}


	public void setDateExpire(String dateExpire) {
		this.dateExpire = dateExpire;
	}


	public CD(String id, String name, double current, double interestRate, String dateExpire) {
		super(id, name, current);
		this.interestRate = interestRate;
		this.dateExpire = dateExpire;
	}


	@Override
	public String toString() {
		return super.toString() + interestRate + "\t\t\t" + dateExpire + "\n";
	}

}
