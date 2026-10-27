import java.util.Scanner;

public class Vidu1 {
public static void main(String[] args) {
	Scanner vu = new Scanner(System.in);
	System.out.print("Nhap a= ");
	int a = vu.nextInt();
	
	if (a>0) {
		System.out.println("a la so nguyen duong!");
	}else if (a<0) {
		System.out.println("a la so nguyen am!");
	}else {
		System.out.println("a khong phai nguyen am va nguyen duong");
	}
}
}
