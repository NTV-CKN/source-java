package lab6;

import java.util.Arrays;

public class Ex7 {
	// find the second
	public static String findSecond(int n, char[] charArr) {
		String result = "";
		int count = 1;
		int index = 0;

		while (index < charArr.length - 1) {
			if (charArr[index] == ' ') {
				index++;
				continue;
			}
			if (charArr[index] == charArr[index + 1]) {
				count++;
			} else if (count < n || count > n && charArr[index] != charArr[index + 1]) {
				count = 1;
			} else if (charArr[index] != charArr[index + 1] && count == n) {
				result = String.valueOf(charArr[index]);
				break;
			}
			index++;
		}
		return result;
	}

	// find the frequent most the character
	public static String findSecondChar(String str) {
		char[] charArr = str.toCharArray();
		int[] intArr = new int[128];
		for (int i = 0; i < charArr.length; i++) {
			intArr[(int) charArr[i]] += 1;
		}
		Arrays.sort(charArr);
		Arrays.sort(intArr);
		return Ex7.findSecond(intArr[126], charArr);
	}

	public static void main(String[] args) {
		System.out.println(Ex7.findSecondChar("hello lecturer"));
	}
}
