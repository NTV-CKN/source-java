package BT;

public class ThreadSquared extends Thread{
	SharedData sharedData;
	int squared = 0;
@Override
public void run() {
	for (int i = 0; i < 10; i++) {
		synchronized (sharedData) {
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			sharedData.setCount(2);
			sharedData.notifyAll();
			try {
				sharedData.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			squared = sharedData.getNumber() * sharedData.getNumber();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("PT: "+squared);
			squared= 0;
		}
	}
	synchronized (sharedData) {
	sharedData.notifyAll();	
	}
}
public ThreadSquared(SharedData sharedData) {
	this.sharedData = sharedData;
}
}
