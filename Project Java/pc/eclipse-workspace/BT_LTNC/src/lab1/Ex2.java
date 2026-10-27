package lab1;

import java.util.Scanner;

public class Ex2 {
	public static int findY(int x) {
		return (4 * (x - 3) + 20);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// nhap vao so nguyen x
		System.out.print("Nhap x = ");
		int x = sc.nextInt();
		// xuat ra man hinh so nguyen y = 4(x-3) + 20
		System.out.println("Voi x la " + x + " ta co y = " + Ex2.findY(x));
	}
}
