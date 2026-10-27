package thide1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Bai1 {
	static HashMap<Integer, Integer> listFib = new HashMap<Integer, Integer>();
	static int save = 0;

	public static int fib(int n) {
		if (n == 0 || n == 1) {
			if (listFib.isEmpty()) {
				listFib.put(1, 1);
				listFib.put(0, 1);
			}
			return 1;
		}
		if (listFib.containsKey(n)) {
			return listFib.get(n);
		}
		save = fib(n - 1) + fib(n - 2);
		listFib.put(n, save);
		return save;
	}

	public static String findFibs(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return "Don't find";
			}
		}
		Bai1.fib(n);
		StringBuilder strB = new StringBuilder();
		for (Map.Entry<Integer, Integer> entrys : listFib.entrySet()) {
			if (entrys.getKey() < n) {
				strB.append(entrys.getKey() + " " + entrys.getValue() + "\n");
			}
		}
		return strB.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so n: ");
		int save = sc.nextInt();

		System.out.println(fib(save));
		System.out.println(findFibs(save));
	}
}
