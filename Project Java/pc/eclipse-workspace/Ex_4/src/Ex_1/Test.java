package Ex_1;
import junit.framework.*;
public class Test extends TestCase{
	public void testBankAccount() {		
	 BankAccount ca = new CheckingAccount(	"Earl Gray", "id# 1729", 1.250, 500);
	 BankAccount cd = new CD("Ima Flatt", "id# 4104", 10.123, 0.04, "June 1, 2005");
	 BankAccount sa = new SavingAccount("Annie Proulx", "id# 2992", 800,  0.035);
	 
	 //test
	 assertEquals(ca.toString(), 	"Earl Gray, id# 1729, 1.25, 500.0");
	 assertEquals(cd.toString(), 	"Ima Flatt, id# 4104, 10.123, 0.04, June 1, 2005");
	 assertEquals(sa.toString(), 	"Annie Proulx, id# 2992, 800.0, 0.035");
	}
}
