package SinhKiTuazAZ;

import java.util.Random;

public class Thread1 extends Thread{
	@Override
	public void run() {
		while(SharedData.getData().available()) {
			synchronized (SharedData.getData()) {
				int min = (int)'a';
				int max =(int)'z';
				int limit = max - min;
				Random rad = new Random();
				SharedData.getData().setNumber(rad.nextInt(limit+1)+min);
				System.out.println("Ki tu ngau nhien: "+((char)SharedData.getData().getNumber()));
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				SharedData.getData().totalTime(2000);
				SharedData.getData().notifyAll();
				try {
					SharedData.getData().wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		synchronized (SharedData.getData()) {
			SharedData.getData().notifyAll();
		}
	}
}
