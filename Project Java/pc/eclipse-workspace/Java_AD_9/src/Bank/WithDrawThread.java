package Bank;

public class WithDrawThread extends Thread{
	MyBank myBank;
	String nameThread;
	
	public WithDrawThread(MyBank myBank, String nameThread) {
		super();
		this.myBank = myBank;
		this.nameThread = nameThread;
	}

	@Override
	public void run() {
		myBank.withDraw(nameThread, 1000);
	}
}
