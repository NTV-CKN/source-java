package ex2;

import ex2.babaitap.BiToDecUtils;

/*
 * doi voi cach dung de quy thi em se chia du cho 10, lay phan du dem nhan
 * voi co so 2 ngu k, voi k la bien toan cuc voi gia tri ban dau = 0
 * sau moi lan truy hoi se tang 1 don vi
 */
public class BiToDec {
	static int k = 0;

	public static int biToDecInt(int binary) {
		// trong phuong thuc nay quan li bien toan cuc k
		k = 0;
		return biToDec(binary);
	}

	private static int biToDec(int binary) {
		if (binary == 0) {
			return binary;
		}
		return ((binary % 10) * (int) Math.pow(2, k++) + biToDec(binary / 10));
	}

	// mo rong bai toan voi binary kieu String
	private static String biToDecStr(String binary) {
		if (!BiToDecUtils.isNumberStr(binary))
			return binary;
		k = 0;
		StringBuilder strB = new StringBuilder(binary);
		return process(strB.reverse().toString(), k);
	}

	private static String process(String binary, int k) {
		if (binary.length() == k)
			return "0";
		int num = Integer.parseInt(binary.charAt(k) + "");
		return ((num * (int) Math.pow(2, k)) + Integer.parseInt(process(binary, k + 1))) + "";
	}

	public static void main(String[] args) {
		System.out.println(biToDecInt(1010011111));
		System.out.println(biToDecStr("1010011111100"));
	}
}
