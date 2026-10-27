package lab3;

public class Ex1 {
	public static String answer;

	// sum
	public static int sum(int n) {
		int total = 0;
		return (total += n);
	}

	// avg
	public static double avg(double n, double index) {
		return (n / index);
	}

	// max
	public static int max(int n1, int n2) {
		if (n1 < n2) {
			return n2;
		}
		return n1;
	}

	// while
	public static String solve() {
		StringBuilder strB = new StringBuilder();
		int sum = 0, index = 0, max = 0;
		int number = 1;
		while (number != 0) {
			number = (int) (Math.random() * 100);
			sum += Ex1.sum(number);
			max = Ex1.max(max, number);
			index++;
		}
		strB.append("Sum = " + sum + ", max = " + max + ", avg = " + ((int) (Ex1.avg(sum, index) * 100) / 100.0));
		answer = strB.toString();
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Ex1.solve());
	}
}
