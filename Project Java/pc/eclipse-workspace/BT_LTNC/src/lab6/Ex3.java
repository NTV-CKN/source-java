package lab6;

public class Ex3 {
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

	// count the number of vowels and consonants
	public static String countVC(String str) {
		int countVo = 0;
		int countCo = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Ex3.isVowel(str.toLowerCase().charAt(i))) {
				countVo++;
			} else {
				countCo++;
			}
		}
		return ("Amount vowels: " + countVo + ", consonants: " + countCo);
	}

	public static void main(String[] args) {
		System.out.println(Ex3.countVC("xin chao cac banA"));
	}
}
