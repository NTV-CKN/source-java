package lab7_test;

import junit.framework.TestCase;
import ex2.*;

public class Ex2_Test extends TestCase {
	public void testEx2() {
		Account myAccount = new Account("Vu Dz", "23130390");
		Account[] listAccounts = new Account[10];
		myAccount.setMoney(1000.0);

		for (int i = 0; i < 10; i++) {
			listAccounts[i] = new Account("Acc " + i, "" + i);
		}

		CheckAccount myCheckAccount = new CheckAccount(listAccounts);
		Customer cus = new Customer(myAccount, myCheckAccount);

		// deposit
		assertEquals(cus.getMyAccount().deposit(50.0), 50.0);
		assertEquals(cus.getMyAccount().getMoney(), 950.0);

		// withdrawal
		cus.getMyAccount().withdrawal(50.0);
		assertEquals(cus.getMyAccount().getMoney(), 900.0);

		// balance inquiry
		assertEquals(cus.getMyAccount().getMoney(), 900.0);

		// transfer
		cus.transfer(100.0, "4");
		assertEquals(cus.getMyAccount().getMoney(), 800.0);
	}
}
