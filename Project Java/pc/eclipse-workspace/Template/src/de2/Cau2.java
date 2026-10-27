package de2;

import java.util.HashMap;
import java.util.Map;

public class Cau2 {
	public static boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str1.length(); i++) {
			if (map.containsKey(str1.charAt(i))) {
				map.put(str1.charAt(i), map.get(str1.charAt(i)) + 1);
			} else {
				map.put(str1.charAt(i), 1);
			}
		}
		for (int i = 0; i < str2.length(); i++) {
			if (map.containsKey(str2.charAt(i))) {
				map.put(str2.charAt(i), map.get(str2.charAt(i)) - 1);
			}
		}
		for (Map.Entry<Character, Integer> e : map.entrySet()) {
			if (e.getValue() != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isAnagram("I Lovve Java", "avafJ evoL I"));
	}
}
