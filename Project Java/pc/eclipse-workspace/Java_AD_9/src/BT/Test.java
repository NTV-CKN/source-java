package BT;

public class Test {
public static void main(String[] args) {
	SharedData sharedData = new SharedData();
	Thread t1 = new ThreadIncident(sharedData);
	Thread t2 = new ThreadSquared(sharedData);
	
	t1.start();
	t2.start();
}
}
