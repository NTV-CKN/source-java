package lab4;

import java.util.Arrays;

public class Ex6 {
	static private boolean isOnSet = false;

//a) check array has ascending
	public static boolean isAscArray(int[] arr) {
		isOnSet = true;
		boolean boo = true;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i + 1] < arr[i]) {
				return (boo = false);
			}
		}
		return boo;
	}

	// b) sort array
	public static int[] sortArray(int[] arr) {
		int size = arr.length;
		int swap = 0;
		boolean boo;
		if (isOnSet == false) {
			if (Ex6.isAscArray(arr)) {
				return arr;
			}
		}
		for (int i = 0; i < size; i++) {
			boo = false;
			for (int j = 0; j < size - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					swap = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = swap;
					boo = true;
				}
			}
			if (!boo) {
				break;
			}
		}
		return arr;
	}

	// print array after bubble sort
	public static String printArraySorted(int[] arr) {
		return Arrays.toString(Ex6.sortArray(arr));
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 6, 5 };
		System.out.println(Ex6.isAscArray(arr));
		System.out.println(Ex6.printArraySorted(arr));
	}
}
