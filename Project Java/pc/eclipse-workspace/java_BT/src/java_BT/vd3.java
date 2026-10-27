package java_BT;

import java.util.Scanner;

public class vd3 {
	public static void main(String[] args) {
		Scanner vu = new Scanner(System.in);

		System.out.print("Nhap canh AB= ");
		int c = vu.nextInt();
		System.out.print("Nhap canh AC= ");
		int b = vu.nextInt();
		System.out.print("Nhap canh BC= ");
		int a = vu.nextInt();
int kq = a-b;
		if (Math.abs(kq)< c && c < (a+b)) {
			System.out.println("3 canh nay la cua tam giac deu!");

		} else {
			System.out.println("3 canh nay khong phai la 3 canh tam giac deu!");
		}

	}
}
