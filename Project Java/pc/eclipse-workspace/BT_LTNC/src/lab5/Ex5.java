package lab5;

public class Ex5 {
	static private boolean isOnSet = false;
	static private int plusC[][] = null;
	static private int exceptD[][] = null;
	static public StringBuilder strB = null;

	// set values
	public static void setValues(int[][] a, int[][] b) {
		plusC = new int[a.length][b.length];
		exceptD = new int[a.length][b.length];
		strB = new StringBuilder();
		isOnSet = true;
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				plusC[i][j] = a[i][j] + b[i][j];
				exceptD[i][j] = a[i][j] - b[i][j];
			}
		}
	}

//print matrix
	public static String print(int[][] arr) {
		if (strB == null) {
			strB = new StringBuilder();
		} else if (strB.length() > 0) {
			strB.delete(0, strB.length() - 1);
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				strB.append(arr[i][j] + " ");
			}
			strB.append("\n");
		}
		return strB.toString();
	}

//a) plus matrixs A and B
	public static int[][] plusAB(int[][] a, int[][] b) {
		if (isOnSet == false) {
			Ex5.setValues(a, b);
		}
		return plusC;
	}

	// b) except matrixs A and B
	public static int[][] except(int[][] a, int[][] b) {
		if (isOnSet == false) {
			Ex5.setValues(a, b);
		}
		return exceptD;
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] b = { { 7, 8, 9 }, { 4, 5, 6 }, { 1, 2, 3 } };
		System.out.println(Ex5.print(Ex5.plusAB(a, b)));
		System.out.println(Ex5.print(Ex5.except(a, b)));
	}
}
