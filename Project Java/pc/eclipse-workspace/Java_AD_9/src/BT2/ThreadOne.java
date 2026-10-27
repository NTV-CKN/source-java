package BT2;

import java.util.Random;

//sinh so ngau nhen
public class ThreadOne extends Thread{
	Data data;
	Random random = new Random();
	
public ThreadOne(Data data) {
		super();
		this.data = data;
	}
@Override
public void run() {
	while(data.isAvailable()) {
		synchronized (data) {
			int rad = random.nextInt(101);	
			data.setNumber(rad);
		//	System.out.println(rad);
			data.sum(data.getNumber());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("So ngau nhien: "+data.getNumber());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(rad % 3 ==0) {
				data.setIndex(2);//binh phuong
			}else if(rad%2 == 0){
				data.setIndex(3);//check
			}else {
				System.err.println("So "+rad+" khong chia het cho 2 TH tren!");
				continue;
			}
			data.notifyAll();
			try {
				data.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	synchronized (data) {
		data.notifyAll();	
		}
	
}
}
