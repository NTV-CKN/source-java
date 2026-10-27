package lab1;

import java.util.Scanner;

public class Ex5 {
	public static String changeTime(int totalSeconds) {
		int hour, minute, second;
		String result;
		if (totalSeconds >= 0) {
			hour = (totalSeconds / 3600);
			minute = (totalSeconds % 3600) / 60;
			second = totalSeconds % 60;
			result = hour + ":" + minute + ":" + second;
		} else {
			result = "Tong so gio khong hop le";
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao tong so giay ");
		int totalSeconds = sc.nextInt();
		System.out.println(Ex5.changeTime(totalSeconds));
	}
}
