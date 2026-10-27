package lab6;

public class Ex6 {
//remove all the white space
	public static String removeWhiteSpace(String str) {
		char[] charArr = str.toCharArray();
		StringBuilder strB = new StringBuilder();
		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] == ' ') {
				continue;
			}
			strB.append(charArr[i]);
		}
		return strB.toString();
	}
	public static void main(String[] args) {
		System.out.println(Ex6.removeWhiteSpace("Nguyen Truong Vu "));
	}
}
