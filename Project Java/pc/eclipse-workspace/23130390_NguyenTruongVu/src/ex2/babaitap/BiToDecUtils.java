package ex2.babaitap;

import java.util.Iterator;

public class BiToDecUtils {
	public static boolean isNumberStr(String binary) {
		try {
			for (int i = 0; i < binary.length(); i++) {
				Integer.parseInt(binary.charAt(i) + "");
			}
		} catch (Exception ignore) {
			return false;
		}
		return true;
	}
}
