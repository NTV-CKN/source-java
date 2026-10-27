package lab4;

public class Ex1 {
	// a) find max of array
	public static String findMaxOfArray(int arr[]) {
		int max = Integer.MIN_VALUE;
		int count = 0;
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				count = i;
			}
		}
		str = "The max value: " + max + ", at " + count;
		return str;
	}

	// b) find min value of array
	public static String findMinOfArray(int arr[]) {
		int min = Integer.MAX_VALUE;
		int count = 0;
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		str = "The min value: " + min + ", " + count;
		return str;
	}

	// c)sum of array
	public static int sumOfArray(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, 7, 2, 3, 9, 12 };
		System.out.println(Ex1.findMaxOfArray(arr));
		System.out.println(Ex1.findMinOfArray(arr));
		System.out.println(Ex1.sumOfArray(arr));
	}
}
