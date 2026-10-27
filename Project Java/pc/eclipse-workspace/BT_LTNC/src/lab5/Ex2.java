package lab5;

public class Ex2 {
	// check main diagonal
	public static boolean checkMainDiagonal(int[][] arr, int n) {
		boolean boo = false;
		int levelN = n - 1;
		if (levelN == 0) {
			if (arr[levelN][levelN] != 0) {
				return true;
			} else {
				return false;
			}
		}
		if (arr[levelN][levelN] != 0) {
			boo = true;
		}
		if (Ex2.checkMainDiagonal(arr, levelN) == true || boo == true) {
			boo = true;
		}
		return boo;
	}

//a) check triangle matrix
	public static boolean isTriangleMatrix(int[][] arr) {
		int iCol = 0;
		if (Ex2.checkMainDiagonal(arr, arr.length)) {
			for (int i = 1; i < arr.length; i++) {
				while (iCol < i) {
					if (arr[i][iCol] != 0) {
						return false;
					}
					iCol++;
				}
				iCol = 0;
			}
		}
		return true;
	}

	// b)check symmetry
	public static boolean checkSymmetrySquareMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i == j) {
					continue;
				}
				if (arr[i][j] != arr[j][i]) {
					return false;
				}
			}
		}
		return true;
	}

	// c) check the square matrix through mind
	public static boolean checkThroghMind(int[][] arr) {
		int n = arr.length;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == j) {
					continue;
				}
				if (arr[i][j] != arr[n - i - 1][n - j - 1]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 0, 4, 5 }, { 0, 0, 6 } };
		int[][] arr2 = { { 1, 2, 3 }, { 2, 4, 5 }, { 3, 5, 6 } };
		System.out.println(Ex2.checkMainDiagonal(arr, 3));
		System.out.println(Ex2.isTriangleMatrix(arr));
		System.out.println(Ex2.checkSymmetrySquareMatrix(arr2));
		System.out.println(Ex2.checkThroghMind(arr2));
	}
}
