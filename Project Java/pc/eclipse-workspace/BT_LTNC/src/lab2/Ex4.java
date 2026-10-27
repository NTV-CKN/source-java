package lab2;

public class Ex4 {
	public static String findX(double a, double b) {
		String str = "";
		if (a == 0 && b == 0) {
			str = "Phuong trinh bac mot vo so nghiem";
		} else if (a == 0 && b != 0) {
			str = "Phuong trinh bac 1 vo nghiem";
		} else {
			str = "Phuong trinh bac mot va co nghiem la: " + (-b / a);
		}
		return str;
	}

	public static String solveQuadratic(double a, double b, double c) {
		String str = "";
		if (a != 0) {
			double delta = b * b - 4 * a * c;
			if (delta < 0) {
				str = "Phuong trinh vo nghiem";
			} else if (delta == 0) {
				str = "Phuong trinh co nghiem kep: " + (-b / (2 * a));
			} else {
				double x1 = (int) ((-b + Math.sqrt(delta)) / (2 * a) * 100) / 100.0;
				double x2 = (int) ((-b - Math.sqrt(delta)) / (2 * a) * 100) / 100.0;
				str = "Phuong trinh co 2 nghiem phan biet: " + "x1 = " + x1 + ", x2 = " + x2;
			}
		} else {
			str = Ex4.findX(b, c);
		}
		return str;
	}

	public static void main(String[] args) {
		System.out.println(Ex4.solveQuadratic(1, -5, 2));
		System.out.println(Ex4.solveQuadratic(2, 1, -6));
		System.out.println(Ex4.solveQuadratic(0, 2, 5));
		System.out.println(Ex4.solveQuadratic(0, 0, 0));
	}
}
