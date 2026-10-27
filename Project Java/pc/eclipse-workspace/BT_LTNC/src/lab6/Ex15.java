package lab6;

public class Ex15 {
//capitalize
	public static String capitalize(String str) {
		StringBuilder strB = new StringBuilder(' ' + str.toLowerCase().trim());
		for (int i = 0; i < strB.length(); i++) {
			if(strB.charAt(i) == ' ') {
				strB.setCharAt(i + 1, (char) ((int)strB.charAt(i + 1) - 32));
			}
		}
		return strB.toString().trim();
	}
	public static void main(String[] args) {
		System.out.println(Ex15.capitalize("Nguyen TRuong VU "));
	}
}
