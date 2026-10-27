package ex1;

public abstract class Ex1Utils {
	public static boolean isUpChar(char ch) {
		return (ch >= 65 && ch <= 90) ? true : false;
	}

	public static boolean isLowChar(char ch) {
		return (ch >= 97 && ch <= 122) ? true : false;
	}

	public static int rotation(int firstChar, int tail, int lastChar) {
		int temp = tail - lastChar;
		if (temp <= 0) {
			return tail;
		} else {
			return rotation(firstChar, temp + firstChar, lastChar);
		}
	}

	public static int reRotation(int step, int val) {
		int k = step;
		for (int i = val; i > 64; i--) {
			if (k == 0) {
				return i;
			} else {
				k--;
			}
		}
		while (k >= 0) {
			for (int i = 90; i > 64; i--) {
				if (k == 0) {
					return i;
				} else {
					k--;
				}
			}
		}
		return -1;
	}
}
