package BT2;
//check chia het 4?
public class ThreadThree extends Thread{
	Data data;
	public ThreadThree(Data data) {
		super();
		this.data = data;
	}

	@Override
	public void run() {
		while(data.isAvailable()) {
			synchronized (data) {
				data.notifyAll();
				while(data.getIndex() != 3 && data.isAvailable()) {
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
				if(data.getNumber()%2==0) {
					if(data.getNumber()%4==0) {
						System.out.println("So "+data.getNumber()+" chia het cho 4!");
					}else {
						System.out.println("So "+data.getNumber()+" khong chia het cho 4!");
					}
				}
				data.setIndex(1);
			}
		}
		synchronized (data) {
		data.notifyAll();	
		}
	}
}
