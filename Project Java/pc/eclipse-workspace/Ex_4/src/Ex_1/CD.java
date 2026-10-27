package Ex_1;
/**
 * trong CD co 3 thuoc tinh va 1 phuong thuc tu BankAccount:
 -String maturityDate
 -double interestRate
-double currentBalance

	@Override
	public double currentBalance() {
		return currentBalance;
	}
	=>tra ve so du hien tai voi gia tri double
  	*duoc ke thua tu lop BankAccount
 */
public class CD extends BankAccount{
	private double interestRate;//lai suat
	private String maturityDate;//han 
	private double currentBalance;//so du hien tai
	public CD(String idNumber, String customerName, double currentBalance, double interestRate, String maturityDate) {
		super(idNumber, customerName);
		this.currentBalance = currentBalance;
		this.interestRate = interestRate;
		this.maturityDate = maturityDate;
	}
	//getter and setter
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public String getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}
	@Override
	public double currentBalance() {
		return currentBalance;
	}
	//toString
	@Override
	public String toString() {
		return super.toString() +", "+ this.currentBalance() +", "+ this.getInterestRate() + ", "+this.getMaturityDate();
	}
	
}
