package lab3;

public class Ex5 {
	// save variable
	static StringBuilder strB = null;

	// get data
	public static StringBuilder getData() {
		if (strB == null) {
			strB = new StringBuilder();
		}
		return strB;
	}

	// find odd major biggest
	public static int findOddMajorBiggest(int number) {
		int omt = -1;
		for (int i = 1; i < number; i++) {
			if ((i % 2) == 1 && (number % i) == 0) {
				omt = i;
			}
		}
		return omt;
	}

	// check prime
	public static boolean isPrime(int number) {
		boolean boo = true;
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				boo = false;
			}
		}
		return boo;
	}

	// find prime numbers
	public static String primeNumbers(int n) {
		Ex5.getData().delete(0, Ex5.getData().length());
		int x = 2;
		int result = n;
		for (int i = 2; i < n; i++) {
			if (Ex5.isPrime(n)) {
				Ex5.getData().append(1 + ", " + n);
				return Ex5.getData().toString();
			} else if ((result % x) == 0) {
				result = result / x;
				Ex5.getData().append(x + " ");
				continue;
			} else if ((n % x) == 1) {
				x++;
			}
		}
		Ex5.getData().append(result);
		return Ex5.getData().toString();
	}

	// look for primes number
	public static String lookForPrimesNumber(int n) {
		Ex5.getData().delete(0, Ex5.getData().length());
		for (int i = 2; i < n; i++) {
			if (Ex5.isPrime(i)) {
				Ex5.getData().append(i + ", ");
			}
		}
		if (strB.toString().endsWith(", ")) {
			Ex5.getData().delete(strB.toString().length() - 2, strB.toString().length());
		}
		return Ex5.getData().toString();
	}

	public static void main(String[] args) {
		System.out.println(Ex5.findOddMajorBiggest(7));// 1
		System.out.println(Ex5.isPrime(31));// true
		System.out.println(Ex5.primeNumbers(72));// 2 2 2 9
		System.out.println(Ex5.lookForPrimesNumber(23));//2, 3, 5, 7, 11, 13, 17, 19
	}
}
