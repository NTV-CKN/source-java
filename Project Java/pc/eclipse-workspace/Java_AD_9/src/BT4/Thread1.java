package BT4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Thread1 extends Thread{

	List<Integer>list1 = new ArrayList<Integer>();
	
	public Thread1() {
		super();
	}
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			Random rad = new Random();
			for (int i = 0; i < 10; i++) {
				list1.add(rad.nextInt(100)+1);
			}
			for (Integer integer : list1) {
				System.out.print(integer + " ");
			}
			System.out.println("\n");
	}
}
