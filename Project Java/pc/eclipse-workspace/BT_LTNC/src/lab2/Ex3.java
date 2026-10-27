package lab2;

public class Ex3 {
	public static String findX(double a, double b) {
		String str = "";
		if (a == 0 && b == 0) {
			str = "Phuong trinh vo so nghiem";
		} else if (a == 0 && b != 0) {
			str = "Phuong trinh vo nghiem";
		} else {
			str = "" + (-b / a);
		}
		return str;
	}
	public static void main(String[] args) {
		System.out.println(Ex3.findX(0, 0));
		System.out.println(Ex3.findX(0, 5));
		System.out.println(Ex3.findX(2, 5));
		System.out.println(Ex3.findX(2, -5));
	}
}
