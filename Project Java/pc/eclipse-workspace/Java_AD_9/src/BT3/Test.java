package BT3;

public class Test {
public static void main(String[] args) {
	SharedData sharedData= new SharedData();
	Thread t1 = new ThreadOne(sharedData);
	Thread t2 = new ThreadTwo(sharedData);
	
	t1.start();
	t2.start();
}
}
