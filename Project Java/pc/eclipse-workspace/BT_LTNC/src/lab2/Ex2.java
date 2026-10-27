package lab2;

public class Ex2 {
	// a)
	public static boolean checkLeapYear(int year) {
		if (year % 400 == 0) {
			return true;
		} else if (year % 100 == 0) {
			return false;
		} else if (year % 4 == 0) {
			return true;
		}
		return false;
	}

	// b)
	public static String getDaysInMonth(int month, int year) {
		String str = "";
		if (month < 1 || month > 12) {
			str = "Thang khong hop le";
		}
		int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (month == 2 && checkLeapYear(year)) {
			str = "Thang " + month + ", nam " + year + " co so ngay la 29";
		}else {
			str = "Thang " + month + ", nam " + year + " co so ngay la: " + daysInMonth[month - 1];
		}
		return str;
	}

	public static void main(String[] args) {
		// a)
		System.out.println(Ex2.checkLeapYear(2004));
		System.out.println(Ex2.checkLeapYear(2005));
		System.out.println(Ex2.checkLeapYear(2008));
		// b)
		System.out.println(Ex2.getDaysInMonth(3, 2024));
		System.out.println(Ex2.getDaysInMonth(2, 2024));
		System.out.println(Ex2.getDaysInMonth(5, 2024));
	}
}
