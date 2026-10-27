package ex3;

import java.util.Arrays;

/*
 *	Dau tien em se tach cac mang ve moi phan tu don bang de quy ket hop chia nhi phan.
 *Sau khi da dua ve mang 1 phan tu thi em bat dau phan vung 2 mang do
 *trong 1 mang result va tra ve result cho ket qua lan goii de quy truoc do, cu nhu
 *vay em da sap xep xong
 */
public class BonusPoint {
	public static int[] callMergeSort(int arr[]) {
		return mergeSort(arr, 0, arr.length - 1);
	}

	private static int[] mergeSort(int arr[], int iL, int iR) {
		if (iL == iR) {
			int[] single = { arr[iL] };
			return single;
		}
		int k = (iL + iR) / 2;
		// tach
		/*
		 * arr1 va 2 se de quy den khi tach cac phan tu thanh moi man
		 */
		int[] arr1 = mergeSort(arr, iL, k);
		int[] arr2 = mergeSort(arr, k + 1, iR);

		// tron
		/*
		 * o day em dung partition ma khong phai insert
		 */
		return partition(arr1, arr2);
	}

	private static int[] partition(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length + arr2.length];
		int i1 = 0, i2 = 0, indexCur = 0;
		while (indexCur < result.length) {
			if (i1 < arr1.length && i2 < arr2.length) {
				if (arr1[i1] >= arr2[i2]) {
					result[indexCur++] = arr2[i2++];
				} else {
					result[indexCur++] = arr1[i1++];
				}
			} else if (i1 < arr1.length) {
				result[indexCur++] = arr1[i1++];
			} else if (i2 < arr2.length) {
				result[indexCur++] = arr2[i2++];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 1, 6, 4, 8, 2, 9, 0 };
		int newArr[] = callMergeSort(arr);
		System.out.println(Arrays.toString(newArr));
	}
}
