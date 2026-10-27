package Student;

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Method md = new Method();
	int save = 0;
	try {
			do {
				System.out.println("Nhap 1 de bat dau\nNhap so bat ki de thoat");
				save = sc.nextInt();
				md.start();
			} while (save == 1);
	} catch (Exception e) {
		System.err.println("LOI");
	}

}
}
