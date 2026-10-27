package BT4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Thread2 extends Thread{
	List<Character>list2 = new ArrayList<Character>();
	public Thread2() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Random rad = new Random();
		for (int i = 0; i < 10; i++) {
			int number = rad.nextInt(26)+97;
			list2.add((char)number);
		}
		for (Character character : list2) {
			System.out.print(character+" ");
		}
	}
}
