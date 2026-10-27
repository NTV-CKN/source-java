package lab6;

public class Ex14 {
	// remove all the white space
	public static String removeWhiteSpace(String str) {
		int indexCurrent = 0, countSize = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				countSize++;
			}
		}

		char[] arrChar = new char[countSize];
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				arrChar[indexCurrent++] = str.charAt(i);
			}
		}
		return String.valueOf(arrChar);
	}

	public static void main(String[] args) {
		System.out.println(Ex14.removeWhiteSpace("Nguyen Truong Vu "));
	}
}
