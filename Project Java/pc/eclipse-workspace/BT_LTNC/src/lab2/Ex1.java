package lab2;

public class Ex1 {
	public static double findMax(double a, double b) {
		if (a > b) {
			return a;
		}
		return b;
	}
	public static void main(String[] args) {
		System.out.println(Ex1.findMax(2, 3));
		System.out.println(Ex1.findMax(3, 2));
		System.out.println(Ex1.findMax(2, 2));
		System.out.println(Ex1.findMax(2, -3));
	}
}
