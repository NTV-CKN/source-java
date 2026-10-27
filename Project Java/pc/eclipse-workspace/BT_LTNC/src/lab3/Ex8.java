package lab3;

public class Ex8 {
	// a) solve sum of the number
	public static int sumNumber(int n) {
		int total = 0;
		for (int i = 1; i <= n; i++) {
			total += i;
		}
		return total;
	}

	// b) solve factorial of the number
	public static int factorialNumber(int n) {
		int total = 1;
		for (int i = 1; i <= n; i++) {
			total *= i;
		}
		return total;
	}

	public static void main(String[] args) {
		System.out.println(Ex8.sumNumber(7));
		System.out.println(Ex8.factorialNumber(7));
	}
}
