package BT;

import java.util.Random;

public class ThreadIncident extends Thread{
	SharedData sharedData;
	public ThreadIncident(SharedData sharedData) {
		super();
		this.sharedData = sharedData;
	}
	Random rad = new Random();

@Override
public void run() {
	for (int i = 0; i < 10; i++) {
		synchronized (sharedData) {
			if(i == 0 && sharedData.getCount()==0) {
				sharedData.notifyAll();
				try {
					sharedData.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sharedData.setNumber(rad.nextInt(101));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Rad: "+ sharedData.getNumber());
			sharedData.notifyAll();
			try {
				sharedData.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
	}
	synchronized (sharedData) {
		sharedData.notifyAll();
	}
}
}
