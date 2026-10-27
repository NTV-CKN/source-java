package lab1;

import java.util.Scanner;

public class Ex3 {
	public static String changeMilesToKm(double milesD) {
		String result;
		if (((int) milesD - milesD) < 0 && milesD >= 0) {
			result = milesD + " miles change to km is: " + (milesD * 1.609);
		} else if (((int) milesD - milesD) == 0 && milesD >= 0) {
			result = milesD + " miles change to km is: " + ((int) milesD * 1.609);
		} else {
			result = "So miles cua ban khong hop le";
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// in ra man hinh yeu cau nguoi dung nhap vao 1 so
		System.out.print("Moi ban nhap miles can doi: ");
		double milesD = sc.nextDouble();

		System.out.println(changeMilesToKm(milesD));
	}
}
