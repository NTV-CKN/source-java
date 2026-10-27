package Bank;

import java.util.ArrayList;
import java.util.List;

public class Test {
public static void main(String[] args) throws InterruptedException {
	MyBank myBank = new MyBank(10000);
	List<WithDrawThread> threadList = new ArrayList<WithDrawThread>();
	
	for (int i = 0; i < 20; i++) {
		threadList.add(new WithDrawThread(myBank, "Thread "+i));
	}
	
	for (WithDrawThread withDrawThread : threadList) {
		withDrawThread.start();// withDrawThread.join();
	}
}
}
