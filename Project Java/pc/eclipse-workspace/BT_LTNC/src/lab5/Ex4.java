package lab5;

public class Ex4 {
	static public StringBuilder strB = null;

	// calculate per line of square matrix
	public static String solveSquareMatrix(int[][] arr) {
		if (strB == null) {
			strB = new StringBuilder();
		} else {
			strB.delete(0, strB.length() - 1);
		}
		int max = Integer.MIN_VALUE;
		int sumPerLine = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sumPerLine += arr[i][j];
			}
			strB.append("Row " + i + " :" + sumPerLine + "\n");
			max = Math.max(max, sumPerLine);
			sumPerLine = 0;
		}
		strB.append(max);
		return strB.toString();
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 9 }, { 3, 4, 5, 6 } };
		System.out.println(Ex4.solveSquareMatrix(arr));
	}
}
