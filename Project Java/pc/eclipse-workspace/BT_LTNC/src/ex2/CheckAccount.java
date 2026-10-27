package ex2;

import java.util.Arrays;

public class CheckAccount {
	private Account listAccount[] = new Account[1];

	// constructor
	public CheckAccount(Account[] listAccount) {
		for (int i = 0; i < listAccount.length; i++) {
			if (this.listAccount[this.listAccount.length - 1] != null) {
				this.listAccount = UpgradeSize.upgS(this.listAccount);
			}
			this.listAccount[i] = listAccount[i];
		}
	}

	// get list account
	public Account getAccount(int index) {
		return listAccount[index];
	}

	// check list
	public boolean checkListAccount(String numberCard, Customer cus) {
		for (int i = 0; i < listAccount.length; i++) {
			if (this.listAccount[i].getNumberCard().equals(numberCard)) {
				cus.setIndexCurrent(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "listAccount: \n" + Arrays.toString(listAccount);
	}

}
