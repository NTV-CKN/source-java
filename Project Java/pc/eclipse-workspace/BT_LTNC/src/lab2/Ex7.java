package lab2;

public class Ex7 {
	public static String checkTriangle(double a, double b, double c) {
		String str = "";
		if (a > 0 && b > 0 && c > 0) {
			if (a == c && a == b && b == c) {
				str = "Equilateral triangle";
			} else if (b == c || c == a || b == a) {
				str = "Right isosceles triangle";
			} else if ((a + b) > c && (a + c) > b && (b + c) > a) {
				str = "Scalene triangle";
			}else {
				str = "Don't accept";
			}
		} else {
			str = "Formatting don't suit";
		}
		return str;
	}

	public static void main(String[] args) {
		System.out.println(Ex7.checkTriangle(0, 1, 3));
		System.out.println(Ex7.checkTriangle(3, 2, 4));
		System.out.println(Ex7.checkTriangle(3, 3, 4));
		System.out.println(Ex7.checkTriangle(3, 3, 3));
		System.out.println(Ex7.checkTriangle(1, 2, 3));
	}
}
