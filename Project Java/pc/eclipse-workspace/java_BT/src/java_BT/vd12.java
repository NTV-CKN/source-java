package java_BT;

import java.util.Scanner;

public class vd12 {
public static int sum(int a, int b) {
	int sum = a+b;
	return sum;
}
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	System.out.println("x= ");
	int x = sc.nextInt(); 
	System.out.println("y= ");
	int y = sc.nextInt();
	
	System.out.println(vd12.sum(x, y));
}
}
