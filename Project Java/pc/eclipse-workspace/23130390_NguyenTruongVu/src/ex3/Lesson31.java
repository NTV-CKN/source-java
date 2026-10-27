package ex3;

public class Lesson31 {
	// linear search
	public static boolean checkNumByLinear(int arr[], int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return true;
			}
		}
		return false;
	}

	// binary search
	public static boolean checkNumByBi(int arr[], int target) {
		int iL = 0, iR = arr.length - 1;
		int k = (iL + iR) / 2;
		while (iL <= iR) {
			if (arr[k] == target)
				return true;
			if (arr[k] > target) {
				iR = k - 1;
				k = (iL + iR) / 2;
			} else {
				iL = k + 1;
				k = (iL + iR) / 2;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr1 = { 4, 6, 7, 5, 8, 9, 10, 12, 15 };
		int[] arr2 = { 23, 45, 56, 67, 78, 92, 101, 120, 136 };

		/*
		 * tai arr1 do binary search chi co the dam bao do chinh xac khi mang
		 * do da duoc sap xep truoc, nen khi kiem tra so 5 thi ket qua khong tim thay.
		 * Trong truong hop nay Linear nhanh hon
		 */
		System.out.println(checkNumByLinear(arr1, 5));
		System.out.println(checkNumByBi(arr1, 5));
		
		/*
		 * Day la 1 mang da duoc sap xep truoc nen BS co the dam bao 
		 * chinh xac, o day toc do cua BS se nhanh hon Linear, vi target = 136
		 * viec lap lai cua Linear trong truong hop xau nhat la n lan
		 */
		System.out.println(checkNumByLinear(arr2, 136));
		System.out.println(checkNumByBi(arr2, 136));
		
		
	}
}
