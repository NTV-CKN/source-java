package Ex_1;
/**
 * trong BankAccount co 2 thuoc tinh va mot phuong thuc abstract:
 -String idNumber
-String customerName

+double currentBalance();
	*day la lop cha cua 3 lop con la: CheckingAccount, SavingAccount, CD
	
	vidu:
	 BankAccount ca = new CheckingAccount(	"Earl Gray", "id# 1729", 1.250, 500);
	 BankAccount cd = new CD("Ima Flatt", "id# 4104", 10.123, 0.04, "June 1, 2005");
	 BankAccount sa = new SavingAccount("Annie Proulx", "id# 2992", 800,  0.035);
	 
	 //test
	 assertEquals(ca.toString(), 	"Earl Gray, id# 1729, 1.25, 500.0");
	 assertEquals(cd.toString(), 	"Ima Flatt, id# 4104, 10.123, 0.04, June 1, 2005");
	 assertEquals(sa.toString(), 	"Annie Proulx, id# 2992, 800.0, 0.035");
	}
	 
 */
public abstract class BankAccount {
	private String idNumber;//ma id cua khach
	private String customerName;//ten khach hang
	//constructor
	public BankAccount(String customerName, String idNumber) {
		this.idNumber = idNumber;
		this.customerName = customerName;
	}
	
	//toString
	@Override
	public String toString() {
		return this.getCustomerName() + ", " + this.idNumber  ;
	}
	//getter and setter
	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	//currentBalance
	public abstract double currentBalance();
	
}
