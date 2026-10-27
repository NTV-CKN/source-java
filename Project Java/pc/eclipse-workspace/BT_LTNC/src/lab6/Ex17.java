package lab6;

public class Ex17 {
	static public String strResult  = "";
//return all substrings possible
	public static String returnSubstring(String str) {
		StringBuilder strB = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				strB.append(str.substring(i, j + 1) + " ");
			}
			strB.append("\n");
		}
		strResult = strB.toString();
		return strB.toString();
	}

	public static void main(String[] args) {
		System.out.println(Ex17.returnSubstring("abcd"));
	}
}
