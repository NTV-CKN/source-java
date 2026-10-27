package bubble_sort;

public class Solution {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int[] arr = { 13,1, 2, 3, 5, 6, 7, 8, 9, 11, 12, 14, 15, 18, 17 };
		int sizeArr = arr.length;
		int temp;
		int count = 0;
		System.out.println("Arr raw");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 0; i < sizeArr; ) {
			boolean boo = true;
			for (int j = 0; j < sizeArr - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					boo = false;
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			sizeArr--;
			System.out.println("Loop: " + i);
			for (int iI : arr) {
				System.out.print(iI + " ");
			}
			System.out.println();
			if (boo) {
				break;
			}
		}
		System.out.println("\nArr after");

		long end = System.currentTimeMillis();
		System.out.println("Runtime " + (end - start) + " ms");
	}
}
