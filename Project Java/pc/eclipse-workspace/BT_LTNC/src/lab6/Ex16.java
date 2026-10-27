package lab6;

public class Ex16 {
	// check if a given string is a palindrome or not
	public static boolean isPalindrome(String str) {
		int size = str.length();
		for (int i = 0; i < size; i++) {
			if (i >= (size - i - 1)) {
				break;
			}
			if (str.charAt(i) != str.charAt(size - i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(Ex16.isPalindrome("level"));
		System.out.println(Ex16.isPalindrome("radar"));
		System.out.println(Ex16.isPalindrome("truong vu"));
	}
}
