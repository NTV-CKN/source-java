package de3;

public class Bai1 {
	public static int wordCount(String str) {
		String strS = str.trim();
		int count = 1;
		// dddd d ddd
		for (int i = 1; i < strS.length(); i++) {
			if (Character.isLetter(strS.charAt(i)) && strS.charAt(i - 1) == ' ') {
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(wordCount("      ddd     d  d d d d  d"));
	}
}
