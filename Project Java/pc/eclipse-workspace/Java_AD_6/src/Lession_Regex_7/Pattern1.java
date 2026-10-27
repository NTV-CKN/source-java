package Lession_Regex_7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pattern1 {
public static void main(String[] args) {
	String[] arr = new String[] {"Ngo Ba Kha", "Vu Dai Ca","ngu thi chet"};
	String str = "u";
//	Pattern pt = Pattern.compile("^.*"+str+".*$");
	Pattern pt = Pattern.compile("^(?=.*Vu).*$");
	Matcher m ;
	for (String string : arr) {
		m= pt.matcher(string);
		if(m.find()) {
			System.out.println(string);
		}
	}
}
}
