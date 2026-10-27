package BT3;

public class ThreadTwo extends Thread{
	SharedData sharedData;

	public ThreadTwo(SharedData sharedData) {
		super();
		this.sharedData = sharedData;
	}
	@Override
	public void run() {
		synchronized (sharedData) {
			for (int i = 0; i < 10; i++) {
			sharedData.notifyAll();
			try {
				sharedData.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		for (int j = 0; j <sharedData.getNumber(); j++) {
			System.out.print(" "+j);
		}	
		System.out.print("\n");
			}
		}
		synchronized (sharedData) {
		sharedData.notifyAll();	
		}
	}
}
