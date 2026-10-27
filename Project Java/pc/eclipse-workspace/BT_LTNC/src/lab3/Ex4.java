package lab3;

public class Ex4 {
	// get greatest common divisor
	public static int getGcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return getGcd(b, a % b);
	}

	// get least common multiple
	public static int getLcm(int a, int b) {
		return (a * b) / Ex4.getGcd(a, b);
	}

	public static void main(String[] args) {
		// input 1:
		System.out.println("Get gcd = " + Ex4.getGcd(18, 12));// result = 6
		System.out.println("Get lcm = " + Ex4.getLcm(18, 12));// result = 36
		// input 2:
		System.out.println("Get gcd = " + Ex4.getGcd(2, 0));// result = 2
		System.out.println("Get lcm = " + Ex4.getLcm(2, 0));// result = 0
	}
}
