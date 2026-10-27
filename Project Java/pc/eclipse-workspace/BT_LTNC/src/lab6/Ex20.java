package lab6;

public class Ex20 {
//remove all special characters
	public static String removeSC(String str) {
		StringBuilder strB = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isLetter(str.charAt(i))) {
				strB.append(str.charAt(i));
			}
		}
		return strB.toString();
	}

	public static void main(String[] args) {
		System.out.println(Ex20.removeSC("nguyen truong @ *&%$## dsscs"));
	}
}
