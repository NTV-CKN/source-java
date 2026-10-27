package lab4;

public class Ex7 {
//a) check symmetry
	public static boolean isSymmetry(int[] arr) {
		int j = arr.length - 1;
		for (int i = 0; i < (arr.length / 2); i++) {
			if (arr[i] != arr[j]) {
				return false;
			}
			j--;
		}
		return true;
	}

	// b) check intertwined
	public static boolean isIntertwined(int[] arr) {
		int size = arr.length;
		int j = size - 1;
		for (int i = 0; i < (size / 2); i++) {
			if (size % 2 == 1) {
				if (arr[i] > 0 && arr[j] < 0 || arr[i] < 0 && arr[j] > 0) {
					return false;
				}
			} else {
				if (arr[i] > 0 && arr[j] > 0 || arr[i] < 0 && arr[j] < 0) {
					return false;
				}
			}
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] arr1 = { 4, 2, 7, 3, 7, 2, 4 };
		int[] arr2 = { 2, -1, 7, -3, 4, -7, 4 };
		System.out.println(Ex7.isSymmetry(arr1));
		System.out.println(Ex7.isIntertwined(arr2));

	}
}
