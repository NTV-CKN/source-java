package lab2;

public class Ex6 {
	public static String solve(double a, double b, double c) {
		String str = "";
		if (a > 0 && b > 0 && c > 0) {
			if ((a + b) > c && (b + c) > b && (b + c) > a) {
				double p = (a + b + c) / 2;
				double s = (int) (Math.sqrt(p * (p - a) * (p - b) * (p - c)) * 100) / 100.0;
				double cosA = (b * b + c * c - a * a) / (2 * b * c);
				double tgA = Math.sqrt(((1 / (cosA * cosA))) - 1);
				double cornerA = (int) (Math.atan(tgA) * 100) / 100.0;
				str = "Perimeter of a triangle: " + (a + b + c) + ", area: " + s + ", corner A: " + cornerA;
			} else {
				str = "Thong so khong hop le";
			}
		} else {
			str = "Canh tam giac khong duoc am";
		}
		return str;
	}

	public static void main(String[] args) {
		System.out.println(Ex6.solve(3, 3, 4));
		System.out.println(Ex6.solve(-1, 0, 0));
		System.out.println(Ex6.solve(1, 2, 3));
	}
}
