import java.util.Scanner;
import java.util.Stack;

public class Chuyen {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 2 to complete");
		int nhap;

		vudeptrai: do {
			System.out.println("Nhap tung so ");
			nhap = sc.nextInt();
			if (nhap == 2) {
				break vudeptrai;
			} else if (nhap >= 0 && nhap <= 1) {
				stack.push(nhap);
			} else {
				System.out.println("So khong hop le nhap lai ");
				continue vudeptrai;
			}
		} while (true);

		int tong = 0;
		// int i = 0;
		for (int i = 0; stack.isEmpty() == false; i++) {
			tong = tong + stack.pop() * (int) Math.pow(2, i);
		}
		System.out.println("Ket qua: " + tong);
	}
}
