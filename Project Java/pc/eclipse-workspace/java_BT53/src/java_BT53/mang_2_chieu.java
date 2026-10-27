package java_BT53;

import java.util.Arrays;
import java.util.Iterator;

public class mang_2_chieu {
	public static void main(String[] args) {

		int[][] dx = { { 4, 5, 3, 7, 8 }, // phan tu 0 co 5 phan tu 1 chieu
				{ 7, 3, 1, 2, 3 }, // phan tu 1 co 5 phan tu 1 chieu
				{ 34, 2, 3, 54, 5 } // phan tu 2 co 5 phan tu 1 chieu
		};
		// truy xuat du lieu tat ca cac phan tu tren
		System.out.println("truy xuat mang 2 chieu qua sap xep:");
		for (int i = 0; i < dx.length; i++) {
			for (int j = 0; j < dx[0].length - 1; j++) {
				for (int j2 = 1 + j; j2 < dx[0].length; j2++) {
					if (dx[i][j] > dx[i][j2]) {
						int temp = dx[i][j];
						dx[i][j] = dx[i][j2];
						dx[i][j2] = temp;
					}
				}
				System.out.print(dx[i][j] + "  ");
			}

		}

	}
}
