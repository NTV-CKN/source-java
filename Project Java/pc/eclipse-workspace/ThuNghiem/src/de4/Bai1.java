package de4;

public class Bai1 {
	public static String wordCorrect(String str) {
		if (str.equals(null)) {
			return str;
		}
		StringBuilder strB = new StringBuilder(str.toLowerCase().trim());
		if (strB.charAt(0) >= 97 && strB.charAt(0) <= 122) {
			strB.setCharAt(0, (char) ((int) (strB.charAt(0)) - 32));
		}
		for (int i = 1; i < str.length(); i++) {
			if (strB.charAt(i - 1) == ' ') {
				if (strB.charAt(i) >= 97 && strB.charAt(i) <= 122) {
					strB.setCharAt(i, (char) ((int) (strB.charAt(i)) - 32));
				}
			}
		}
		return strB.toString();
	}

	public static void main(String[] args) {
		// 97 122
		System.out.println(wordCorrect("acdA Kl lA"));
	}
}
