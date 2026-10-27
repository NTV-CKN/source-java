package lab1;

import java.util.Scanner;

public class Ex1 {
	public static float multiple(int x, float y) {
		return x * y;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input one integer and one floating-point number");
		System.out.print("x = ");
		int x = sc.nextInt();
		// in ra man hinh yeu cau nguoi dung nhap 2 con so
		System.out.print("y = ");
		float y = sc.nextFloat();

		System.out.println("Input values are " + x + "and " + y + "their product is " + (Ex1.multiple(x, y)));
	}
}
