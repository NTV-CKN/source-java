package de5;

import java.util.ArrayList;
import java.util.List;

public class Bai3 {
	private List<Account> list;

	public List<Account> getList() {
		return list;
	}

	public Bai3() {
		list = new ArrayList<Account>();
	}

	public void createAccounts() {
		Account[] checkingAccounts = { new CheckingAccount("check1", "Vu Check", 123, 2.5),
				new CheckingAccount("check2", "Vu Ne", 1232, 1.2), new CheckingAccount("check3", "Vu dz", 12342, 8.2),
				new CheckingAccount("check4", "Vu map dit", 123222, 12.2) };
		Account[] savingAccounts = { new SavingAccount("save1", "Hoa1", 123213, 2.3),
				new SavingAccount("save2", "Hoa5", 1232, 1.3), new SavingAccount("save3", "Hoaw", 1232, 4.3) };
		Account[] cds = { new CD("cd1", "caigi", 12322, 2.3, "12/2/2005"),
				new CD("cd2", "cairang", 12322, 1.3, "13/2/2005"), new CD("cd3", "caiMote", 12322, 5.3, "11/2/2003") };
		int count = 0, count2 = 0, count3 = 0;
		for (int i = 0; i < 10; i++) {
			if (i == 0 && i < 4) {
				list.add(checkingAccounts[count++]);
			}
			if (i == 4 && i < 7) {
				list.add(savingAccounts[count2++]);
			}
			if (i == 7 && i < 10) {
				list.add(cds[count3++]);
			}
		}
	}
}
