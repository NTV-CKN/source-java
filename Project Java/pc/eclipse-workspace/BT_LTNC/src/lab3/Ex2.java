package lab3;

import java.util.Arrays;

public class Ex2 {
	// count numbers of n
	public static int countNumber(int n) {
		int count = 0;
		int saveVariable = n;
		while (saveVariable != 0) {
			saveVariable /= 10;
			count++;
		}
		return count;
	}
	//revolve the number
	public static String revolveNumber(int n) {
		String str = n + "";
		String arr[] = str.split("");
		int condition = (arr.length/2);
		int i = 0, j = (arr.length - 1);
		while(i < condition) {
			String swap = arr[i];
			arr[i] = arr[j];
			arr[j] = swap;
			i++; j--;
		}
		return Arrays.toString(arr);
	}
	public static void main(String[] args) {
		System.out.println(Ex2.countNumber(1123456789));//10
		System.out.println(Ex2.revolveNumber(12345678));//[8, 7, 6, 5, 4, 3, 2, 1]
	}
}
