package lab2;

import java.util.regex.Pattern;

public class Ex10 {
	// check leap year
	public static boolean isLeapYear(int year) {
		if (year % 400 == 0) {
			return true;
		} else if (year % 100 == 0) {
			return false;
		} else if (year % 4 == 0) {
			return true;
		}
		return false;
	}

	// get day numbers of month
	public static int monthCalendar(int month, int year) {
		int dayNumbers = 0;
		switch (month) {

		case 1: {
			dayNumbers = 31;
			break;
		}
		case 2: {
			if (Ex10.isLeapYear(year)) {
				dayNumbers = 29;
			} else {
				dayNumbers = 28;
			}
			break;
		}
		case 3: {
			dayNumbers = 31;
			break;
		}
		case 4: {
			dayNumbers = 30;
			break;
		}
		case 5: {
			dayNumbers = 31;
			break;
		}
		case 6: {
			dayNumbers = 30;
			break;
		}
		case 7: {
			dayNumbers = 31;
			break;
		}
		case 8: {
			dayNumbers = 31;
			break;
		}
		case 9: {
			dayNumbers = 30;
			break;
		}
		case 10: {
			dayNumbers = 31;
			break;
		}
		case 11: {
			dayNumbers = 30;
			break;
		}
		case 12: {
			dayNumbers = 31;
			break;
		}
		}
		return dayNumbers;
	}

	// check d/m/y
	public static String checkFormat(int d, int m, int y) {
		String str = "";
		if(d <= 0 || y <= 0 || m <= 0) {
			return (str = "Don't accept");
		}
		if (d < Ex10.monthCalendar(m, y)) {
			str = (d + 1) + "/" + m + "/" + y;
		} else if (d == Ex10.monthCalendar(m, y)) {
			d = 1;
			if (m < 12) {
				str = d + "/" + (m + 1) + "/" + y;
			}else if(m == 12) {
				m = 1;
				str = d + "/" + m + "/" + (y + 1);
			}
		}else {
			str = "Numbers don't correct format d/m/y";
		}
		return str;
	}
	public static void main(String[] args) {
		System.out.println(Ex10.checkFormat(21, 14, 2000));
		System.out.println(Ex10.checkFormat(-1, 0, 0));
		System.out.println(Ex10.checkFormat(29, 2, 1996));
		System.out.println(Ex10.checkFormat(28, 2, 1997));
		System.out.println(Ex10.checkFormat(30, 3, 2024));
		System.out.println(Ex10.checkFormat(31, 12, 2005));
	}
}
