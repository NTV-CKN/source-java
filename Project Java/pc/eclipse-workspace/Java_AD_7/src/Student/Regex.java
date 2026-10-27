package Student;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	
	public static String isRegexName() {
		String name="";
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Nhap ten");
			name = sc.nextLine();
			Pattern pName = Pattern.compile("^([A-Z][a-z]{1,} )+$");
			Matcher mName = pName.matcher(name);
	if(mName.find()) {
		break;
	}else {
		System.err.println("Ten Student Khong Hop Le!");
	}
		}
			return name;
}
	public static String isRegexId() {
		String name;
		while(true) {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Nhap id");
			name = sc.nextLine();
	Pattern pId = Pattern.compile("^(231)[0-9]{5}$");
	Matcher mId = pId.matcher(name);
	if(mId.find()) {
		break;
	}else {
		System.err.println("Id Student Khong Hop Le!");
	}
	}
		return name;
}
}
