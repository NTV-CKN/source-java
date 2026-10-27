package thi_de5;

public class Bai2 {
	//
	public static String removeUpper(String str) {
		StringBuilder strB = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				strB.append(str.charAt(i));
			}
		}
		return strB.toString();
	}

	public static void main(String[] args) {
		System.out.println(removeUpper("VUDEPtrattyIUUu"));
	}
}
