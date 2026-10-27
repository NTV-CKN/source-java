package lab6;

public class Ex12 {
	// write a method to reverse String. Don't use reverse()
	public static String reverseString(String str) {
		char[] charArr = str.toCharArray();
		char swap;
		int j = charArr.length - 1;
		for (int i = 0; i < (charArr.length / 2); i++) {
			swap = charArr[i];
			charArr[i] = charArr[j];
			charArr[j] = swap;
			j--;
		}
		String strResult = new String(charArr);
		return strResult;
	}

	public static void main(String[] args) {
		String str = "Hello lecturer";
		System.out.println(Ex12.reverseString(str));
	}
}
