package lab5;

public class Ex3 {
	static public StringBuilder strB = null;

//a)matrix transfer
	public static int[][] transfer(int[][] arr) {
		int sizeRow = arr.length;
		int sizeCol = arr[sizeRow - 1].length;
		int[][] newArray = new int[sizeCol][sizeRow];
		for (int i = 0; i < sizeRow; i++) {
			for (int j = 0; j < sizeCol; j++) {
				newArray[j][i] = arr[i][j];
			}
		}
		return newArray;
	}

	// print
	public static String printMatrix(int[][] arr) {
		if (strB == null) {
			strB = new StringBuilder();
		} else {
			strB.delete(0, strB.length() - 1);
		}
		int[][] arrPrint = arr;
		for (int i = 0; i < arrPrint.length; i++) {
			for (int j = 0; j < arrPrint[0].length; j++) {
				strB.append(arrPrint[i][j] + " ");
			}
			strB.append("\n");
		}
		return strB.toString();
	}

	// b) position change
	public static int[][] positionChange(int[][] arr) {
		int save = (arr.length / 2);
		int swap = 0, n = arr.length;
		for (int i = 0; i <= save; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (i == (n - i - 1) && j == (n - j - 1)) {
					break;
				}
				swap = arr[i][j];
				arr[i][j] = arr[n - i - 1][n - j - 1];
				arr[n - i - 1][n - j - 1] = swap;
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		int[][] arr1 = { { 2, 3, 4 }, { 5, 6, 7 }, { 1, 2, 3 } };
		int[][] arr2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(Ex3.printMatrix(Ex3.transfer(arr1)));
		System.out.println(Ex3.printMatrix(Ex3.positionChange(arr2)));
	}
}
