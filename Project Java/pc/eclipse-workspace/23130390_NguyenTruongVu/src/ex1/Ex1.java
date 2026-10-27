package ex1;

/*
 * thuat toan toi te nhat
 * ket hop de quy de kiem tra so lan tien cua k
 */
public class Ex1 {
	public static String encrypt(int kt, String str) {
		StringBuilder strB = new StringBuilder();
		char[] chars = str.toCharArray();
		int k = kt % 26;
		for (int i = 0; i < chars.length; i++) {
			if (Ex1Utils.isLowChar(chars[i])) {
				chars[i] = (char) Ex1Utils.rotation(96, chars[i] + k, 122);
			} else if (Ex1Utils.isUpChar(chars[i])) {
				chars[i] = (char) Ex1Utils.rotation(64, chars[i] + k, 90);
			}
		}
		for (char c : chars) {
			strB.append(c);
		}
		return strB.toString();
	}
	public static String decrypt(int step, String str) {
		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if(Ex1Utils.isLowChar(chars[i])) {
				chars[i] = (char) (Ex1Utils.reRotation(step, chars[i] - 32) + 32);
			}else if(Ex1Utils.isUpChar(chars[i])) {
				chars[i] = (char) Ex1Utils.reRotation(step, chars[i]);
			}
		}
		StringBuilder strB = new StringBuilder();
		for (char c : chars) {
			strB.append(c);
		}
		return strB.toString();
	}
	

	public static void main(String[] args) {
		System.out.println(encrypt(48, "Y"));
		System.out.println(encrypt(49, "Return to Caesar what belongs to Caesar, and to God what belongs to God"));
		System.out.println(decrypt(49, "Obqrok ql Zxbpxo texq ybilkdp ql Zxbpxo, xka ql Dla texq ybilkdp ql Dla"));
	}
}
