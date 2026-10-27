package java_BT;

import java.util.Scanner;

public class vd2 {
	public static void main(String[] args) {
		Scanner vu = new Scanner(System.in);
		System.out.println("Nhap n= ");
		int n = vu.nextInt();

		switch (n) {
		case 1:
			System.out.println("Mot");
			break;
		case 2:
			System.out.println("Hai");
			break;
		case 3:
			System.out.println("Ba");
			break;
		default:
			System.out.println("Nhap lai");
			break;
		}
	}
}
