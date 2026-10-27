package de7;

public class Cau1 {
	public static String findCouple(int x, int[] arr) {
		StringBuilder strB = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if ((arr[i] + arr[j]) == x) {
					strB.append(arr[i] + " " + arr[j] + "\n");
				}
			}
		}
		return strB.toString();
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 1, 2 };
		System.out.println(findCouple(3, arr));
	}
}
