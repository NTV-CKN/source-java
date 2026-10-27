package ex2.babaitap;

public class Rec7 {
	private static int count = 0;

	public static int countOddNum(int num) {
		if(num <= 0) return -1;
		count = 0;
		count(num);
		return count;
	}

	private static void count(int num) {
		if (num == 0) {
			return;
		}
		if ((num % 10) % 2 == 1) {
			count++;
			count(num / 10);
		} else {
			count(num / 10);
		}
	}
	public static void main(String[] args) {
		System.out.println(countOddNum(123456789));
	}
}
