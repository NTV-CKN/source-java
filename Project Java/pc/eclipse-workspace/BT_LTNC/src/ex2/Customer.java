package ex2;

public class Customer {
	private Account myAccount;
	private CheckAccount myCheckAccount;
	private int indexCurrent = -1;

	// constructor
	public Customer(Account myAccount, CheckAccount myCheckAccount) {
		this.myAccount = myAccount;
		this.myCheckAccount = myCheckAccount;
	}

	// getter and setter
	public int getIndexCurrent() {
		return indexCurrent;
	}

	public void setIndexCurrent(int indexCurrent) {
		this.indexCurrent = indexCurrent;
	}

	// check account
	public boolean checkAccount(String numberCard) {
		if (this.myAccount.getNumberCard().equals(numberCard)) {
			return false;
		} else if (myCheckAccount.checkListAccount(numberCard, this)) {
			return true;
		}
		return false;
	}

	// transferring funds between accounts
	public void transfer(double amount, String numberCard) {
		if (this.checkAccount(numberCard)) {
			this.myCheckAccount.getAccount(indexCurrent).setMoney(this.myAccount.deposit(amount));
			this.setIndexCurrent(-1);
		}
	}

	// getter and setter
	public Account getMyAccount() {
		return myAccount;
	}

	public CheckAccount getMyCheckAccount() {
		return myCheckAccount;
	}

	@Override
	public String toString() {
		return "myAccount: " + myAccount + ", myCheckAccount: \n" + myCheckAccount + "]";
	}
}
