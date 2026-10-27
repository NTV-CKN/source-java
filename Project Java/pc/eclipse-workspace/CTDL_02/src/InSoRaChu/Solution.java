package InSoRaChu;

import java.nio.charset.StandardCharsets;

public class Solution {
	public static String[] createArr() {
		String[] arr = new String[21];
		if(arr[0] == null) {
		arr[0] = "không";
		arr[1] = "một";
		arr[2] = "hai";
		arr[3] = "ba";
		arr[4] = "bốn";
		arr[5] = "năm";
		arr[6] = "sáu";
		arr[7] = "bảy";
		arr[8] = "tám";
		arr[9] = "chín";
		arr[10] = "mười";
		arr[11] = "mười một";
		arr[12] = "mười hai";
		arr[13] = "mười ba";
		arr[14] = "mười bốn";
		arr[15] = "mười lăm";
		arr[16] = "mười sáu";
		arr[17] = "mười bảy";
		arr[18] = "mười tám";
		arr[19] = "mười chín";
		arr[20] = " mười lăm";
		}else {
			return arr;
		}
		return arr;
	}
public static void printWord(int n) {
	String arr[] = Solution.createArr();
	int n1, n2, n3, n4;
	if(n >= 0 && n < 1000) {
		if (n <= 19) {
			n1 = n / 10;
			n2 = n % 10;
			if (n < 10) {
				System.out.println(arr[n2]);
			} else if (n == 10) {
				System.out.println(arr[n]);
			} else {
				System.out.println(arr[n]);
			}
		} else if (n <= 99) {
			n1 = n / 10;
			n2 = n % 10;
			if (n2 == 0) {
				System.out.println(arr[n1] + " mươi");
			} else {
				if (n2 == 1 && n1 > 1) {
					System.out.println(arr[n1] + " mươi mốt");
				} else if (n2 == 5) {
					System.out.println(arr[n1] + arr[20]);
				} else {
					System.out.println(arr[n1] + " mươi " + arr[n2]);
				}
			}
		} else if (n < 1000) {
			n1 = n / 100;// tram
			n2 = (n % 100) / 10;// chuc
			n3 = n % 10;// donvi
			n4 = n % 100;
			if (n2 == 0 && n3 == 0) {
				System.out.println(arr[n1] + " trăm");
			} else if (n2 == 0) {
				System.out.println(arr[n1] + " trăm lẻ " + arr[n3]);
			} else if (n3 == 0) {
				if (n2 > 1) {
					System.out.println(arr[n1] + " trăm " + arr[n2] + "mươi");
				} else {
					System.out.println(arr[n1] + " trăm mười");
				}
			} else if (n3 == 1 && n2 > 1) {
				System.out.println(arr[n1] + " trăm " + arr[n2] + " mươi " + "mốt");
			} else if (n4 >= 20) {
				if (n3 != 5) {
					System.out.println(arr[n1] + " trăm " + arr[n2] + " mươi " + arr[n3]);
				} else {
					System.out.println(arr[n1] + " trăm " + arr[n2] + arr[20]);
				}
			} else {
				System.out.println(arr[n1] + " trăm " + arr[n4]);
			}
		}
	}else {
		System.err.println("So " + n + " khong nam trong pham vi tu 0 den 1000");
	}
}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		for (int i = -2; i < 200; i++) {
			Solution.printWord(i);
		}
		long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Thời gian thực thi: " + executionTime + "ms");
	}
}
