package lab1;

import java.util.Scanner;

public class Ex4 {

	public static String areaCircleAndPerimeter(double radius) {
		String result;
		if (radius < 0) {
			result = "Thong so ban kinh khong hop le";
		} else {
			result = "Dien tich hinh tron la: " + (int) (Math.PI * radius * radius * 100) / 100.0 + "\n"
					+ "Chu vi hinh tron la: " + (int) (2 * Math.PI * radius * 100) / 100.0;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap vao ban kinh ");
		double radius = sc.nextDouble();
		System.out.println(Ex4.areaCircleAndPerimeter(radius));

	}
}