package lab6;

public class Ex5 {
//check two strings are anagram or not
	public static boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		for (int i = 0; i < str1.length(); i++) {
			// listStr1.add(str1.charAt(i));
			for (int j = 0; j < str2.length(); j++) {
				if (str1.charAt(i) == str2.charAt(j)) {
					break;
				} else if (j == (str2.length() - 1) && str1.charAt(i) != str2.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(Ex5.isAnagram("Nguyen Truong Vu", "Vu Nguyen Truong"));
		System.out.println(Ex5.isAnagram("Anh hai", "anh hai"));
	}
}
