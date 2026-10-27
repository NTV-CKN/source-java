package Lession1;

import java.util.Scanner;

public class Main {	

public static void main(String[] args) {
	try {
		int arr[] = new int[3];
	Scanner sc = new Scanner(System.in);
	for (int i = 0; i <= arr.length; i++) {
		System.out.printf("Nhap arr[%d] ", i );
		int save = sc.nextInt();
	}}catch(Exception e){
		System.out.println(e.getMessage());
	}finally {
		System.out.println("h");
	}

try {
	System.out.println(Calculator.divide(5, 0));
} catch (CustomException e) {
	// TODO Auto-generated catch block
	System.out.println(e.getMessage());
}
}}
