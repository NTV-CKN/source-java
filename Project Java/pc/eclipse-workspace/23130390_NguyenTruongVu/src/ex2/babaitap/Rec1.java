package ex2.babaitap;

import java.util.Iterator;
import java.util.Stack;

public class Rec1 {
//bi to dec rec
	// mo rong bai toan voi binary kieu String
	private static String biToDecStr(String binary) {
		if (!BiToDecUtils.isNumberStr(binary))
			return binary;
		StringBuilder strB = new StringBuilder(binary);
		return process(strB.reverse().toString(), 0);
	}

	private static String process(String binary, int k) {
		if (binary.length() == k)
			return "0";
		int num = Integer.parseInt(binary.charAt(k) + "");
		return ((num * (int) Math.pow(2, k)) + Integer.parseInt(process(binary, k + 1))) + "";
	}

//bi to dec khu de quy
	public static int biToDecNonRec(String binary) {
		if (!BiToDecUtils.isNumberStr(binary))
			return -1;
		int save = 0;
		int size = binary.length() - 1;
		for (int i = 0; i < binary.length(); i++) {
			save += (Integer.parseInt(binary.charAt(i) + "") * (int) Math.pow(2, size--));
		}
		return save;
	}

// dec to bi
	// rec
	public static String decToBiRec(int num) {
		return processDecToBiRec(num);
	}

	private static String processDecToBiRec(int num) {
		if (num == 0) {
			return "";
		}
		return processDecToBiRec(num / 2) + (num % 2);
	}

	// non rec
	public static String decToBiNonRec(int num) {
		int save = num;
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder strB = new StringBuilder();
		while (save > 0) {
			stack.push(save % 2);
			save /= 2;
		}
		while(!stack.isEmpty()) {
			strB.append(stack.pop());
		}
		return strB.toString();
	}

	public static void main(String[] args) {
		System.out.println(biToDecStr("1010011"));
		System.out.println(biToDecNonRec("1010011"));
		System.out.println(decToBiRec(83));
		System.out.println(decToBiNonRec(83));
	}
}
