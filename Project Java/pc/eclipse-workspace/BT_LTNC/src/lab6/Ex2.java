package lab6;

public class Ex2 {
//check if a given string is a palindrome or not
	public static boolean isPalindrome(String str) {
		int j = str.length() - 1;
		for (int i = 0; i < (str.length() / 2); i++) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			j--;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(Ex2.isPalindrome("level"));
		System.out.println(Ex2.isPalindrome("radar"));
		System.out.println(Ex2.isPalindrome("truong vu"));
	}
}
