package lab2;

public class Ex9 {
	public static String returnOneToTen(int number) {
		String str = "";
		switch (number) {
		case 0: {
			str = "khong";
			break;
		}
		case 1: {
			str = "mot";
			break;
		}
		case 2: {
			str = "hai";
			break;
		}
		case 3: {
			str = "ba";
			break;
		}
		case 4: {
			str = "bon";
			break;
		}
		case 5: {
			str = "nam";
			break;
		}
		case 6: {
			str = "sau";
			break;
		}
		case 7: {
			str = "bay";
			break;
		}
		case 8: {
			str = "tam";
			break;
		}
		case 9: {
			str = "chin";
			break;
		}
		case 10: {
			str = "muoi";
			break;
		}
		}
		return str;
	}

	public static String returnString(int number) {
		String str = "";
		StringBuilder strB = new StringBuilder(str);
		int ht = number / 100;
		int hc = (number / 10) % 10;
		int dv = number % 10;
		if (number >= 0 && number <= 10) {
			strB.append(Ex9.returnOneToTen(number));
		} else if (number > 10 && number < 20) {
			hc = number / 10;
			strB.append("muoi " + Ex9.returnString(hc));
		} else if (dv == 0 && hc > 0 && ht == 0) {
			strB.append(Ex9.returnString(hc) + " muoi");
		} else if (hc == 0 && dv == 0) {
			strB.append(Ex9.returnString(ht) + " tram ");
		} else if (number > 20 && number < 100 && dv == 5) {
			strB.append(Ex9.returnString(hc) + " muoi lam");
		} else if (number > 20 && number < 100) {
			strB.append(Ex9.returnString(hc) + " muoi " + Ex9.returnString(dv));
		} else if (number > 100 && number < 1000 && hc == 0 && dv > 0) {
			strB.append(Ex9.returnString(ht) + " tram le " + Ex9.returnString(dv));
		} else if (number > 100 && number < 1000) {
			hc = number % 100;
			strB.append(Ex9.returnString(ht) + " tram " + Ex9.returnString(hc));
		}
		return strB.toString();
	}

	public static void main(String[] args) {
		System.out.println(Ex9.returnString(125));
		System.out.println(Ex9.returnString(901));
		System.out.println(Ex9.returnString(950));
		System.out.println(Ex9.returnString(11));
	}
}
