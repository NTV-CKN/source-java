package thide1;

public class Bai2 {
	static int save = 0;

	public static boolean findNT(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static int findMax(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				save = Math.max(matrix[i][j], save);
			}
		}
		return save;
	}

	public static String findENT(int[][] matrix) {
		StringBuilder strB = new StringBuilder();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (findNT(matrix[i][j])) {
					strB.append(matrix[i][j] + " ");
				} else {
					strB.append(0 + " ");
				}
			}
			strB.append("\n");
		}
		return strB.toString();
	}

	public static int findRowsNT(int[][] matrix) {
		int count = 0, save = 0, indexCur = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (findNT(matrix[i][j])) {
					count++;
				}
			}
			if (count >= save) {
				indexCur = i;
				save = count;
			}
			count = 0;
		}
		return indexCur + 1;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 11, 8, 9, 5 }, { 5, 5, 5, 4 }, { 5, 5, 5, 5 } };
		System.out.println(findMax(matrix));
		System.out.println(findENT(matrix));
		System.out.println(findRowsNT(matrix));
	}
}
