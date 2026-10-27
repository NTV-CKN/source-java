package Lession_Regex_7;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	try {
		Scanner sc = new Scanner(System.in);
			System.out.println("Nhap 1 de bat dau\nNhap bat ki so de thoat");
			int c12 = sc.nextInt();
	if (c12 == 1) {
		do {
			System.out.println("Nhap 3 de tao mang");
			System.out.println("Nhap 5 de xuat mang");
			System.out.println("Nhap 6 de ket thuc");
			System.out.println("=========================");
			int str = sc.nextInt();
			if(str == 3) {
				Array.array();
			}else if(str == 5) {
				System.out.println(Arrays.toString(Array.array));
			}else if(str == 6) {
				System.out.println("CLOSE SYSTEM");
				System.exit(0);
			}
		} while (c12 == 1);
	}
	} catch (Exception e) {
		System.err.println("NHAP KHONG HOP LE!");
	}finally {
		System.out.println("END PROGRAM");
	}

}
	
}
