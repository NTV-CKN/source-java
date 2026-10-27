package Lession_Regex_4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void checkEmail() {
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap email: ");
			String str =sc.nextLine();	
			String strr = "!";
			Pattern p1 = Pattern.compile("^[a-zA-Z][\\w-_]+"+strr+"([a-zA-Z]+\\.)+[a-zA-Z]+$");
			Matcher mc = p1.matcher(str);
			if(mc.find()) {
				System.out.println(str);
				break;
			}else {
				System.err.println("BAN NHAP LOI!");
			}
			}
	}
	public static double getOneDivideTwo() {
		double save = 0;
		while(true) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so: ");
		String str =sc.nextLine();	
		Pattern p1 = Pattern.compile("^-*[0-9]+(\\.[5]|\\.[0]+|\\.[5][0]+)?$");
		Matcher mc = p1.matcher(str);
		if(mc.find() && Double.parseDouble(str) >=8 && Double.parseDouble(str)<=17.5) {
			save = Double.parseDouble(str);
			break;
		}else {
			System.err.println("BAN NHAP LOI!");
		}
		}
		return save%0.5;
	}
	public static void getAccount() {
			while(true) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap account: ");
		String str =sc.nextLine();	
		Pattern p1 = Pattern.compile("^-*[0-9]+(\\.[5]|\\.[0]+|\\.[5][0]+)?$");
		Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-zA-Z]).{10}$");
		Matcher mc = p1.matcher(str);
	
			if(mc.find()) {
				System.out.println("Complete");
				break;
			}else {
				System.err.println("Please input again!");
				
			}
		}
	}
	
	public static void getPassword() {	
		while(true) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap password: ");
		String str =sc.nextLine();	
		Pattern p1 = Pattern.compile("^(?=-*)[0-9]+(\\.[5])|()$");
		Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-zA-Z]).{8,31}$");
		Matcher mc = p1.matcher(str);
	
			if(mc.find()) {
				System.out.println("Complete");
				break;
			}else {
				System.err.println("Please input again!");
			}
		}
	}
public static void main(String[] args) {
	Main.checkEmail();
	

}
}
