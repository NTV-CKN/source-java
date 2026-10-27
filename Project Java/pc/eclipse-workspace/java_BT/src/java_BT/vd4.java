package java_BT;

import java.util.Scanner;

public class vd4 {
public static void main(String[] args) {
	Scanner vu = new Scanner(System.in);
	
	System.out.print("Nhap canh huyen= ");
	int c = vu.nextInt();
	System.out.print("Nhap canh ke= ");
	int b = vu.nextInt();
	System.out.print("Nhap canh doi= ");
	int a = vu.nextInt();
	
	if (Math.pow(c, 2) == (Math.pow(b, 2) + Math.pow(a, 2))){
		System.out.println("Day la tam giac vuong!");
	}else {
		System.out.println("Khong phai tam giac vuong!");
	}
}
}
