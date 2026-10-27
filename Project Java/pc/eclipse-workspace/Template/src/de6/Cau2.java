package de6;

public class Cau2 {
	public static int USCLN(int a, int b) {
		for (int i = Math.min(a, b); i > 0; i--) {
			if (a % i == 0 && b % i == 0) {
				return i;
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		System.out.println(USCLN(15, 18));
	}
}
