package ex2.babaitap;

public class Rec13 {
	public static boolean isAllOddNum(int num) {
		if (num <= 0)
			return false;
		return check(num);
	}

	private static boolean check(int num) {
		if (num == 0) {
			return true;
		}
		if ((num % 10) % 2 != 1) {
			return false;
		} else {
			return check(num / 10);
		}
	}
	public static void main(String[] args) {
		System.out.println(isAllOddNum(13579));
	}
}
