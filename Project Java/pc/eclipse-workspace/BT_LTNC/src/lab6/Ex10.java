package lab6;

public class Ex10 {
//check if a given string is digits
	public static boolean isDigit(String str) {
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if ((int) c[i] < 48 || (int) c[i] > 57) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(Ex10.isDigit("Nguyen 123"));
		System.out.println(Ex10.isDigit("2345120978"));
		System.out.println(Ex10.isDigit("2k5"));
	}
}
