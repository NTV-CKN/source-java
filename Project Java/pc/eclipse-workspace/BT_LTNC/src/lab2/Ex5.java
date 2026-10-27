package lab2;

public class Ex5 {
	public static String findLengthIAndU(int a1, int a2, int b1, int b2) {
		String str = "";
		if (a2 > b1) {
			str = "Length of Insection: " + (a2 - b1) + ", length of union: " + (((a2 - a1) + (b2 - b1)) - (a2 - b1));
		} else {
			str = "Length of Insection: " + 0 + ", length of union: " + ((a2 - a1) + (b2 - b1));
		}
		return str;
	}
	public static void main(String[] args) {
		System.out.println(Ex5.findLengthIAndU(-2, 3, 1, 6));
		System.out.println(Ex5.findLengthIAndU(1, 4, 3, 6));
		System.out.println(Ex5.findLengthIAndU(1, 2, 5, 8));
	}
}
