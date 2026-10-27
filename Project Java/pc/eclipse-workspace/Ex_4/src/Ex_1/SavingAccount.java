package Ex_1;
/**
 * trong SavingAccount co 2 thuoc tinh va 1 phuong thuc tu BankingAccount:
-double interestRate
-double currentBalance

+	@Override
	public double currentBalance() {
		return currentBalance;
	}
	=>tra ve so du hien tai voi gia tri double
 	*duoc ke thua tu lop BankAccount
 */
public class SavingAccount extends BankAccount{
	private double interestRate;//lai suat
	private double currentBalance;//so du hien tai
	public SavingAccount(String idNumber, String customerName, double currentBalance, double i) {
		super(idNumber, customerName);
		this.currentBalance = currentBalance;
		this.interestRate = i;
	}
	//setter and getter
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	@Override
	public double currentBalance() {
		return currentBalance;
	}
	//toString
	@Override
	public String toString() {
		return super.toString() +", " + this.currentBalance() +", "+ this.getInterestRate();
	}
	

}
