package de4;

public class Cau1 {
	// 97 122
	public static String wordCorrect(String str) {
		if (str == null) {
			return null;
		}
		StringBuilder strB = new StringBuilder(str.trim());
		for (int i = 0; i < strB.length() - 1; i++) {
			if (i == 0) {
				if (strB.charAt(i) >= 97 && strB.charAt(i) <= 122) {
					strB.setCharAt(i, (char) (strB.charAt(i) - 32));
				}
			} else if (strB.charAt(i) == ' ') {
				if (strB.charAt(i + 1) >= 97 && strB.charAt(i + 1) <= 122) {
					strB.setCharAt(i + 1, (char) (strB.charAt(i + 1) - 32));
				}
			} else if (strB.charAt(i) != ' ') {
				if (strB.charAt(i + 1) >= 97 - 32 && strB.charAt(i + 1) <= 122 - 32) {
					strB.setCharAt(i + 1, (char) (strB.charAt(i + 1) + 32));
				}
			}
		}
		return strB.toString();
	}

	public static void main(String[] args) {
		System.out.println(wordCorrect("NgussNsjs sjss JJSJj     sJSJSJ  "));
	}
}
