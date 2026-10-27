package thi_de5;

public class Bai3 {
	private Account[] myAcc = new Account[10];

	public Account[] myAccount() {
		myAcc[0] = new CheckingAccount("123", "NTv", 123, 333);
		myAcc[1] = new CheckingAccount("123", "NTc", 1123, 233);
		myAcc[2] = new CheckingAccount("121", "NTf", 12123, 313);
		myAcc[3] = new SavingAccount("234", "ntx", 122, 1);
		myAcc[4] = new SavingAccount("233", "nfx", 422, 2);
		myAcc[5] = new SavingAccount("232", "ntf", 112, 3);
		myAcc[6] = new CertificateOfDeposit("CO", "Hhaha", 122, 122, "12/3/2005");
		return myAcc;
	}
	
}
