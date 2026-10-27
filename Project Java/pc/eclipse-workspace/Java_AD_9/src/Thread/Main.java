package Thread;

public class Main {
public static void main(String[] args) throws InterruptedException {
	//cach 1
	Thread t1 = new Thread(new Runnable() {
		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread One, index: "+i);
			}
		}
	});
	
	//cach 2 
	Thread t2 = new ThreadTwo();
	//main thread
		Thread mainThread = new Thread(new Runnable() {
			@Override
			public void run() {
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		for (int i = 0; i < 15; i++) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main Thread, index: "+i);
		System.out.println("State Thread One: " + t1.isAlive());
		System.out.println("State Thread Two: " + t2.isAlive());
			}}
		});
		mainThread.start();
		System.out.println("State Main Thread: " +mainThread.isAlive());


	
	
	
	
}
}
