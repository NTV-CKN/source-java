package lab4;

public class Ex3 {
	static private int countPos = 0, countNeg = 0, countZero = 0, sumPos = 0, sumNeg = 0;
	static private int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static private boolean isOnSet = false;

	// a) count positive, negative, zero of array
	public static String countPosNegZero(int arr[]) {
		if (isOnSet == false) {
			Ex3.setValues(arr);
		}
		return "Amount: positive: " + countPos + ", negative: " + countNeg + ", zero: " + countZero;
	}

	// b) find the max value largest and min value smallest
	public static int findMaxValue(int[] arr) {
		if (isOnSet == false) {
			Ex3.setValues(arr);
		}
		return max;
	}

	public static int findMinValue(int[] arr) {
		if (isOnSet == false) {
			Ex3.setValues(arr);
		}
		return min;
	}

	public static boolean isSumSame(int arr[]) {
		return (Math.abs(sumNeg) == sumPos);
	}

	// set values
	public static void setValues(int arr[]) {
		isOnSet = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				if (max < arr[i]) {
					max = arr[i];
				}
				sumPos += arr[i];
				countPos++;
			} else if (arr[i] < 0) {
				if (min > arr[i]) {
					min = arr[i];
				}
				sumNeg -= arr[i];
				countNeg++;
			} else {
				countZero++;
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 5, -1, -4, 0, 0, 0, 3, -4 };
		System.out.println(Ex3.countPosNegZero(arr));
		System.out.println(Ex3.findMaxValue(arr));
		System.out.println(Ex3.findMinValue(arr));
		System.out.println(Ex3.isSumSame(arr));
	}
}
