package BT3;

import java.util.Random;

//sinh so ngau nhien x
public class ThreadOne extends Thread{
	SharedData sharedData;

	public ThreadOne(SharedData sharedData) {
		super();
		this.sharedData = sharedData;
	}
	@Override
	public void run() {	
				try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		synchronized (sharedData) {
	
			Random rad = new Random();
			for (int i = 0; i < 10; i++) {
				
			sharedData.setNumber(rad.nextInt(10)+1);
			System.out.println("So x la: "+sharedData.getNumber());
			sharedData.notifyAll();
			try {
				sharedData.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		}
		synchronized (sharedData) {
			sharedData.notifyAll();	
			}
	}
}
