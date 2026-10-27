package java_BT;

import java.util.Scanner;

public class vd5 {
public static void main(String[] args) {
	Scanner vu = new Scanner(System.in);
	System.out.println("nhap n= ");
	int n = vu.nextInt();
	int kq = 0;
	
	for (int i = 0; i <= n ; i++) {
		kq = kq + i;
	}System.out.println("kq= "+kq);
}
}
