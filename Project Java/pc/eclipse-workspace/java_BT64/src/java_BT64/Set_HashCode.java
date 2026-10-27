package java_BT64;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Set_HashCode {
public static void main(String[] args) {
    //Set<String> v2 = new HashSet<String>();
	Scanner sc = new Scanner(System.in);
	method v1 = new method();
	int l = 0;
	do {
		
		System.out.println("MOI CHON\nPRESS 1 DE THEM SO\nPRESS 2 DE XOA 1 SO\nPRESS 3 DE KIEM TRA SO\nPRESS 4 DE XOA HET\nPRESS 5 DE LAY SO LUONG\nPRESS 6 DE RUT THAM\nPRESS 7 DE IN RA TOAN BO\nPRESS 9 DE THOAT");
		l = sc.nextInt();
		sc.nextLine();
		if(l == 1) {
			System.out.println("Nhap so");
			String v = sc.nextLine();
			v1.themMa(v);
		}else if(l == 2) {
			System.out.println("Nhap so");
			String v = sc.nextLine();
			v1.xoaMa(v);
		}else if(l == 3) {
			System.out.println("Nhap so");
			String v = sc.nextLine();
			System.out.println(v1.kiemTraMa(v)); 
		}else if(l == 4) {
			v1.xoaAll();
		}else if(l == 5) {
			System.out.println(v1.laySoLuong());
		}else if(l == 6) {
		System.out.println(v1.rutTham()); 
		}else if(l == 7) {
            System.out.println( v1.inRaAll());
}
	} while (l != 0);
}
}
