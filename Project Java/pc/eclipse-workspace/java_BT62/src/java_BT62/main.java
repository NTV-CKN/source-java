package java_BT62;

import java.util.Scanner;
import java.util.Stack;

import javax.print.attribute.Size2DSyntax;

public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<String> vu = new Stack<String>();
		Stack<Integer> vu3 = new Stack<Integer>();
		Stack<String> vu2 = new Stack<String>();
		// dao chuoi
//	System.out.println("Nhap vao chuoi can dao"); String v1 = sc.nextLine();

//	for (int i = 0; i < v1.length(); i++) {
//		vu.push(v1.charAt(i) +"");
//	}
//	int luu = vu.size();
//for (int i = 0; i < luu; i++) {
//        System.out.print(vu.pop());
//}
		int chonChon = 0;
		do {
			System.out.println("PRESS 1 TO SCAN \nPRESS 2 TO CAL \n \t");
			chonChon = sc.nextInt();
			sc.nextLine();
			if (chonChon == 1) {
				System.out.println("Nhap 1 so \n");
				int a = sc.nextInt();
				vu3.push(a);
			}
		} while (chonChon != 2);
		int l = vu3.size();
		double tong = 0;
		for (int j = 0; j < l; j++) {
			tong = Math.pow(2, j) * vu3.pop() + tong;
		}
		System.out.println("Ket qua tu so nhi phan ra thap phan la= " + tong);
	}
}
