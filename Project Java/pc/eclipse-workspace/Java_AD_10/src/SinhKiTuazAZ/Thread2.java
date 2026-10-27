package SinhKiTuazAZ;

public class Thread2 extends Thread{
	@Override
	public void run() {

		while(SharedData.getData().available()) {
			synchronized (SharedData.getData()) {
				int code = SharedData.getData().getNumber()-32;
				System.out.println("Ki tu hoa: "+((char)code));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
