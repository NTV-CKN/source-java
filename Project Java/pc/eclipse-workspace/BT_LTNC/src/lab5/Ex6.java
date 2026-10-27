package lab5;

public class Ex6 {
	static public StringBuilder strB = null;

// multiply matrix
	public static int[][] multiply(int[][] a, int[][] b) {
		if (a[0].length != b.length) {
			return null;
		}
		int[][] c = new int[a.length][b[0].length];
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {
				int sum = 0;
				for (int k = 0; k < a[0].length; k++) {
					sum += a[i][k] * b[k][j];
				}
				c[i][j] = sum;
			}
		}
		return c;
	}

	// print
	public static String print(int[][] c) {
		if (strB == null) {
			strB = new StringBuilder();
		} else if (strB.length() > 0) {
			strB.delete(0, strB.length() - 1);
		}
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c.length; j++) {
				strB.append(c[i][j] + " ");
			}
			strB.append("\n");
		}
		return strB.toString();
	}
	public static void main(String[] args) {
		int[][] a = { {1, 2}, {3, 4}, {5, 6} };
        int[][] b = { {7, 8, 9}, {10, 11, 12} };
        System.out.println(Ex6.print(Ex6.multiply(a, b)));
	}
}
