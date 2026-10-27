package lession2_Excercises;

import java.util.Scanner;

public class Ex3 {
public static void findX() {
	Scanner sc = new Scanner(System.in);
	System.out.println("Nhap a = ");
	double a = sc.nextDouble();
	System.out.println("Nhap b = ");
	double b = sc.nextDouble();
	if(a != 0) {
		System.out.println("Nghiem cua he phuong trinh ax + b = 0 la: " + (-b/a));
	}else if(b == 0) {
		System.out.println("Nghiem cua he phuong trinh ax + b = 0 la: 0");
	}
	else {
		System.out.println("He phuong trinh vo nghiem");
	}
}
}
