package de5;

import java.util.Scanner;

public class Cau1 {
	public static boolean checkSNT(int number) {
		if (number == 1) {
			return true;
		}
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	// 555
	public static int countNumber(int number) {
		if (number == 0) {
			return 1;
		}
		int count = 0, save = number;
		while (save != 0) {
			save /= 10;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao 1 so nguyen: ");
		int save = sc.nextInt();
		if (checkSNT(save)) {
			System.out.println("Good " + countNumber(save));
		} else {
			System.out.println("Bad " + countNumber(save));
		}
	}
}
