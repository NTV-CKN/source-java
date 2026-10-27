package thide2;

import java.util.Scanner;

public class Cau2 {
	public static boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(str2.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao 2 chuoi: ");
		String str1 = sc.nextLine();
		//sc.nextLine();
		String str2 = sc.nextLine();
		if(str1.length() <= 20 && str2.length() <= 20) {
			System.out.println(isAnagram(str1, str2));
		}else {
			System.out.println("Loi");
		}
	}
}
