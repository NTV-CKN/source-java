package lab4;

public class Ex2 {
	// find the max value of array
	public static int maxValueOfArray(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		return max;
	}

	// Count the element max value appear in array
	public static int countAppearMaxE(int[] arr) {
		int count = 0;
		int maxValue = Ex2.maxValueOfArray(arr);
		for (int i = 0; i < arr.length; i++) {
			if (maxValue == arr[i]) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 9, 7, 9, 9, 9, 9, 2 };
		System.out.println(Ex2.countAppearMaxE(arr));
	}
}
