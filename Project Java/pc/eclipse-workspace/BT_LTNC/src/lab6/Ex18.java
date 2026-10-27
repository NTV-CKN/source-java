package lab6;

public class Ex18 {
//reverse string
	public static String reverseString(String str) {
		StringBuilder strB = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			strB.append(str.charAt(i));
		}
		return strB.toString();
	}

	public static void main(String[] args) {
		System.out.println(Ex18.reverseString("abcdef"));
	}
}
