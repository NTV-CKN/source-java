package thi_de5;

public class Bai1 {
	public static boolean kiemTraSNT(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

//123
	public static int countAmountNumber(int n) {
		int save = n, count = 0;
		while (save != 0) {
			count++;
			save /= 10;
		}
		return count;
	}

	public static String goodBad(int n) {
		if (kiemTraSNT(n)) {
			return "Good " + countAmountNumber(n);
		}
		return "Bad";
	}

	public static void main(String[] args) {
		System.out.println(kiemTraSNT(15));
		System.out.println(countAmountNumber(123454));
		System.out.println(goodBad(102));
	}
}
