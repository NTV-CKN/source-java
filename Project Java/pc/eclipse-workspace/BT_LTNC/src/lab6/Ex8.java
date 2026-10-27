package lab6;

public class Ex8 {
//remove the first character and the last character of given a string
	public static String removeFL(String str) {
		char[] charArr = str.toCharArray();
		StringBuilder strB = new StringBuilder();
		for (int i = 1; i < charArr.length - 1; i++) {
			strB.append(charArr[i]);
		}
		return strB.toString();
	}
	public static void main(String[] args) {
		System.out.println(Ex8.removeFL("Nguyen Truong Vu"));
	}
}
