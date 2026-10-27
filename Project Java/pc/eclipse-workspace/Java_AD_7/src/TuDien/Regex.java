package TuDien;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

public static String suitableWord() {
	Scanner sc = new Scanner(System.in);
	Pattern p1 = Pattern.compile("^[A-Z][a-z ]+( [a-z]+)*$");
	String tu="";
	do {
		System.out.println("Nhap tu");
		 tu = sc.nextLine();
		Matcher mc = p1.matcher(tu);
		if(mc.find()) {
			break;
		}
		System.err.println("LOI");
	} while (true);
	return tu;
}
public static String suitableN() {
	Scanner sc = new Scanner(System.in);
	Pattern p1 = Pattern.compile("^[A-Z][a-z]+( [a-z]+)*$");
	String tu="";
	do {
		System.out.println("Nhap nghia");
		 tu = sc.nextLine();
		Matcher mc = p1.matcher(tu);
		if(mc.find()) {
			
			break;
		}
		System.err.println("LOI");
	} while (true);
	return tu;
}
}
