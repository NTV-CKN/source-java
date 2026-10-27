package lab6;

import java.util.Arrays;

public class Ex4 {
//find word largest in given a string
	public static String findMaxWord(String str) {
		char[] charArr = str.toCharArray();
		Arrays.sort(charArr);//
		return String.valueOf(charArr[charArr.length - 1]);
	}

	public static void main(String[] args) {
		System.out.println(Ex4.findMaxWord("Gen z Nguyen Truong Vu"));
	}
}
