package lab6;

public class Ex11 {
	final static char[] CHAR_VOWEL = { 'a', 'e', 'u', 'o', 'y', 'i' };

	// check vowel
	public static boolean isVowel(char c) {
		for (int i = 0; i < CHAR_VOWEL.length; i++) {
			if (c == CHAR_VOWEL[i]) {
				return true;
			}
		}
		return false;
	}

//count vowel in a given string
	public static int countVowel(String str) {
		char[] c = str.toLowerCase().toCharArray();
		int count = 0;
		for (int i = 0; i < c.length; i++) {
			if (Ex11.isVowel(c[i])) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(Ex11.countVowel("bcdrg"));
		System.out.println(Ex11.countVowel("UEeg"));
	}
}
