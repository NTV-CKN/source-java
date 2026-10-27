package thide2;

import java.util.Scanner;

public class Cau1 {
	public static boolean checkSoChinhPhuong(int n) {
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (Math.pow(i, 2) == n) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so n: ");
		int save = sc.nextInt();
		System.out.println(checkSoChinhPhuong(save));
	}
}
