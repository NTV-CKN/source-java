package lab4;

import java.util.Arrays;

public class Ex5 {
	static private int countX = 0;
	static private StringBuilder strB = null;
	static private boolean isX = false, isOnSet = false;

	// set values
	public static void setValues(int[] arr, int x) {
		isOnSet = true;
		strB = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (x == arr[i]) {
				isX = true;
				countX++;
				strB.append(i + " ");
			}
		}
	}

	// a)determine x has exist in array
	public static boolean isExistX(int[] arr, int x) {
		if (isOnSet == false) {
			Ex5.setValues(arr, x);
		}
		return isX;
	}

	// b) return amount x appear and get index at x
	public static String xAtIndex(int[] arr, int x) {
		if (isOnSet == false) {
			Ex5.setValues(arr, x);
		}
		return ("Amount x: " + countX + ", at index: " + strB.toString().trim());
	}

	// c) remove elements contain x
	public static int[] removeX(int[] arr, int x) {
		int size = arr.length;
		for (int i = 0; i < size; i++) {
			if (arr[size - 1] == x) {
				arr[size - 1] = Integer.MIN_VALUE;
			}
			if (arr[i] == x) {
				for (int j = i; j < size - 1; j++) {
					arr[j] = arr[j + 1];
				}
			}
		}
		return arr;
	}

	// return array after remove x
	public static String printArrayNotExistX(int[] arr, int x) {

		return (Arrays.toString(arr) + "\n" + Arrays.toString(Ex5.removeX(arr, x)));
	}

	public static void main(String[] args) {
		int arr[] = { 7, 1, 2, 3, 4, 1, 2, 1, 7 };
		System.out.println(Ex5.isExistX(arr, 7));
		System.out.println(Ex5.xAtIndex(arr, 1));
		System.out.println(Ex5.printArrayNotExistX(arr, 7));

	}
}
