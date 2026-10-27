package Ex_1;
/**
 * trong CheckingAccount co 2 thuoc tinh va 1 phuong thuc tu BankAccount:
 -double minimumBalance
-double currentBalance

+	@Override
	public double currentBalance() {
		return currentBalance;
	}
	=>tra ve so du hien tai voi gia tri double
 	*duoc ke thua tu lop BankAccount
 */
public class CheckingAccount extends BankAccount{
	private double minimumBalance;//so du toi thieu
	private double currentBalance;//so du hien tai
	public CheckingAccount(String idNumber, String customerName,double currentBalance,  double b) {
		super(idNumber, customerName);
		this.currentBalance = currentBalance;
		this.minimumBalance = b;
	}
	//getter and setter
	public double getMinimumBalance() {
		return minimumBalance;
	}
	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	@Override
	public double currentBalance() {
		return currentBalance;
	}	//toString
	@Override
	public String toString() {
		return super.toString()  +", "+this.currentBalance() + ", "+this.getMinimumBalance();

	}
	
}
