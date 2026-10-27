package de5;

import java.util.Scanner;

public class Cau2 {
	public static String lowerString(String str) {
		return str.trim().toLowerCase();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao 1 chuoi");
		System.out.println();
		String str = sc.nextLine();
		System.out.println(lowerString(str));
	}
}
