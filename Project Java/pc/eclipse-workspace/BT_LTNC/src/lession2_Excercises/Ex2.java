package lession2_Excercises;

public class Ex2 {
	//a)
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
	//b)
    public static void getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12) {
            System.err.println("Thang khong hop le");
        }
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && checkLeapYear(year)) {
            System.out.println("Thang " + month + ", nam " + year + " co so ngay la 29");
        }
        System.out.println("Thang " + month + ", nam " + year + " co so ngay la: " + daysInMonth[month - 1]);
    }
}
