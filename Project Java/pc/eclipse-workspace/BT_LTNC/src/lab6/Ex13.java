package lab6;

import java.util.Arrays;

public class Ex13 {
	// check two strings are anagram or not
	public static boolean isAnagram(String str1, String str2) {
		// create two arrays versus data type is char
		char[] charArr1 = str1.toCharArray();
		char[] charArr2 = str2.toCharArray();
		// sort
		Arrays.sort(charArr1);
		Arrays.sort(charArr2);
		// check
		for (int i = 0; i < charArr2.length; i++) {
			if (charArr1[i] != charArr2[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(Ex13.isAnagram("Nguyen Truong Vu", "Vu Nguyen Truong"));
		System.out.println(Ex13.isAnagram("Anh hai", "anh hai"));
	}
}
