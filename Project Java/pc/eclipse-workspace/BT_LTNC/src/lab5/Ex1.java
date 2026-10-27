package lab5;

public class Ex1 {
	static private int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	static private boolean isOnSet = false;

	// set values
	public static void setValues(int arr[][]) {
		isOnSet = true;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (max < arr[i][j]) {
					max = arr[i][j];
				}
				if (min > arr[i][j]) {
					min = arr[i][j];
				}
				sum += arr[i][j];
			}
		}
	}

	// a) find the max value and the min value
	public static String findMN(int[][] arr) {
		if (isOnSet == false) {
			Ex1.setValues(arr);
		}
		return "The min value: " + min + ", the max value: " + max;
	}

	// b) sum the matrix
	public static int sumMatrix(int[][] arr) {
		if (isOnSet == false) {
			Ex1.setValues(arr);
		}
		return sum;
	}

	public static void main(String[] args) {
		int[][] arr = { { 2, 3, 4, 5 }, { 5, 6, 7, 8 }, { 1, 2, 3, 4 } };
		System.out.println(Ex1.findMN(arr));
		System.out.println(Ex1.sumMatrix(arr));
	}
}
