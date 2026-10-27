package ex2;

public class Ex2 {
	public static void main(String[] args) {
		Account myAccount = new Account("Vu Dz", "23130390");
		Account[] listAccounts = new Account[10];
		myAccount.setMoney(1000.0);

		for (int i = 0; i < 10; i++) {
			listAccounts[i] = new Account("Acc " + i, "" + i);
		}
		
		CheckAccount myCheckAccount = new CheckAccount(listAccounts);
		Customer cus = new Customer(myAccount, myCheckAccount);
		
		System.out.println(cus.toString());
		//deposit
		cus.getMyAccount().deposit(50.0);
		System.out.println(cus.getMyAccount().getMoney());
		//withdrawal
		cus.getMyAccount().withdrawal(50.0);
		System.out.println(cus.getMyAccount().getMoney());
		//balance inquiry
		System.out.println(cus.getMyAccount().getMoney());
		//transfer
		cus.transfer(100.0, "4");
		
		System.out.println(cus.toString());
	}
}
