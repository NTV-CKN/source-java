package BT2;
//binh phuong so chia het cho 3
public class ThreadTwo2 extends Thread{
	Data data;
	public ThreadTwo2(Data data) {
		this.data = data;
	}
	@Override
	public void run() {
		while(data.isAvailable()) {
			synchronized (data) {
			data.notifyAll();
			while(data.getIndex() != 2 && data.isAvailable()) {
				try {
					data.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(data.getNumber()%3 == 0) {
				System.out.println("So ngau nhien duoc binh phuong: "+ (data.getNumber()*data.getNumber()));
			}
			data.setIndex(1);
			}
		}
		synchronized (data) {
			data.notifyAll();	
			}
	}
}
