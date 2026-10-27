package thi_de5;

public class CheckingAccount extends Account{
	private double minBalance;
	public CheckingAccount(String id, String name, double cur, double minBalance) {
		super(id, name, cur);
		this.minBalance = minBalance;
	}
	@Override
	public String toString() {
		return super.toString() + "CheckingAccount  [minBalance=" + minBalance + "]";
	}
	public double getMinBalance() {
		return minBalance;
	}
	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

}
