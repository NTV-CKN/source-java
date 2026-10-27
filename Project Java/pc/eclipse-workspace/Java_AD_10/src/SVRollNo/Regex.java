package SVRollNo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	
	public static boolean check(String str) {
		Pattern p = Pattern.compile("^(C|T|N)[0-9]{4}(G|H|I|K|L|M)(V*)[0-9]{4}$");
		Matcher match;
		match = p.matcher(str);
		return match.find();
	}
}
