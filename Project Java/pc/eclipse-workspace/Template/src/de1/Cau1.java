package de1;

import java.util.HashMap;
import java.util.Map;

public class Cau1 {
	public static boolean checkSNT(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static String lietKe(int n) {
		recursion(n);
		StringBuilder strB = new StringBuilder();
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			if (e.getValue() < n && checkSNT(e.getValue())) {
				strB.append(e.getValue() + " ");
			}
		}
		return strB.toString();
	}

	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	public static int recursion(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}

		if (map.containsKey(n)) {
			return map.get(n);
		} else {
			int save = recursion(n - 1) + recursion(n - 2);
			map.put(n, save);
			return save;
		}
	}

	public static void main(String[] args) {
		System.out.println(recursion(8));
		System.out.println(lietKe(9));
	}
}
