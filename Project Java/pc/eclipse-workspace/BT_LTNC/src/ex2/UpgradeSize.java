package ex2;

public class UpgradeSize {
	public static Account[] upgS(Account[] listAcc) {
		Account[] accounts = new Account[listAcc.length + 5];
		for (int i = 0; i < listAcc.length; i++) {
			accounts[i] = listAcc[i];
		}
		return accounts;
	}
}
