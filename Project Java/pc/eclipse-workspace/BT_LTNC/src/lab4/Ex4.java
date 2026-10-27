package lab4;

import java.util.Arrays;

public class Ex4 {
	// reverse
	public static void reverseArray(int[] arr) {
		int swap;
		int size = arr.length - 1;
		for (int i = 0; i < (arr.length / 2); i++) {
			swap = arr[i];
			arr[i] = arr[size];
			arr[size] = swap;
			size--;
		}
	}

	// print array
	public static String printArrayReverve(int arr[]) {
		Ex4.reverseArray(arr);

		return Arrays.toString(arr);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7};
		System.out.println(Ex4.printArrayReverve(arr));
	}
}
