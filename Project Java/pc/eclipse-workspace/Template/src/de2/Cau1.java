package de2;

import java.util.Random;

public class Cau1 {
	public static boolean checkSoChinhPhuong(int number) {
		double count = Math.sqrt(number);
		if ((Math.pow(count, 2) - number) == 0.0) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Random rd = new Random();
		System.out.println(checkSoChinhPhuong(rd.nextInt(Integer.MAX_VALUE) + 1));
	}
}
