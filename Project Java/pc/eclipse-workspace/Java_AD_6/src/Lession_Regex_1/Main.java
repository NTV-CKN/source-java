package Lession_Regex_1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Pattern pName = Pattern.compile("^([A-Z][a-z]{2,} )+$");
	Pattern p = Pattern.compile("^[0-9]{1,2}$");
	Matcher mc;
	do {
		System.out.println("Nhap username: ");
		String str = sc.nextLine();
	 mc = p.matcher(str);
	 if(mc.find()== false) {
		 		 System.err.println("LOI!");
	 }else {
		 break;
	 }
	} while (true);
	System.out.println("Success!");
}
}
