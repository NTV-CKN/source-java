package de3;

public class Cau1 {
	public static int wordCount(String str) {
		if (str == null) {
			return 0;
		}
		String save = str.trim();
		// scss scscs scscscs
		int count = 1;
		for (int i = 0; i < str.length() - 1; i++) {
			if (save.charAt(i) == ' ' && save.charAt(i + 1) != ' ') {
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(wordCount("sscsc    scscs  sscs  s cs cs "));
	}
}
