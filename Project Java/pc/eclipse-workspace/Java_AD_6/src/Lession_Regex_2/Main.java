package Lession_Regex_2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public void getPhone(String str1) {
		Pattern p1 = Pattern.compile("^[A-Z][a-z]+$");
		Pattern p = Pattern.compile("^(\\([0-9]{3}\\)-[0-9]{3}-[0-9]{4})|([0-9]{3}-[0-9]{3}-[0-9]{4} (x|ext)[0-9]{4})$");
		Matcher m;
		String str =str1;
		m = p1.matcher(str);
		if(m.find()) {
			System.out.println("Hop le!");
		}else {
			System.err.println("KHONG HOP LE!");
	}
	}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Main main = new Main();
	System.out.println("Nhap ");
	main.getPhone(sc.nextLine());
}
}
