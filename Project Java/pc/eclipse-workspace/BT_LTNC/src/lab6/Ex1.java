package lab6;

public class Ex1 {
	// write a method to reverse String
	public static String reverseString(String str) {
		return new StringBuilder(str).reverse().toString();
	}

	public static void main(String[] args) {
		String str = "Hello lecturer";
		System.out.println(Ex1.reverseString(str));
	}
}
