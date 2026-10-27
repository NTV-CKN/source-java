package Thread;

public class ThreadTwo extends Thread{
@Override
public void run() {
	for (int i = 0; i < 10; i++) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread Two, index: "+i);
	}
}
}
