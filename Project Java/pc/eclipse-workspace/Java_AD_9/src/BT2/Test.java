package BT2;

public class Test {
public static void main(String[] args) {
	Data data = new Data();
	Thread t1 = new ThreadOne(data);
	Thread t2 = new ThreadTwo2(data);
	Thread t3 = new ThreadThree(data);
	
	t1.start();
	t2.start();
	t3.start();
}
}
