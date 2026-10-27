package thi_de5;

public class SavingAccount extends Account {
	private double interestRate;

	public SavingAccount(String id, String name, double cur, double in) {
		super(id, name, cur);
		this.interestRate = in;
	}

	@Override
	public String toString() {
		return  super.toString() +  "SavingAccount [interestRate=" + interestRate + "]";
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

}
