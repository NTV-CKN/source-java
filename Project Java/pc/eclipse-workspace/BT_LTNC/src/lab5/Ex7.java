package lab5;

public class Ex7 {
	static public StringBuilder strB = null;

//triangle pascal
	public static int[][] trianglePascal(int n) {
		int count = 1;
		int index = 0;
		int[][] c = new int[n + 1][];
		for (int i = 0; i < c.length; i++) {
			c[i] = new int[(count - i)];
			for (int j = count; j > i; j--) {
				c[i][index] = (int) (Math.random() * 10);
				index++;
			}
			index = 0;
			count += 2;
		}
		return c;
	}

	// print
	public static String print(int[][] c) {
		if (strB == null) {
			strB = new StringBuilder();
		} else{
			strB.delete(0, strB.length() - 1);
		}
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				strB.append(c[i][j] + " ");
			}
			strB.append("\n");
		}
		return strB.toString();
	}

	public static void main(String[] args) {
		System.out.println(Ex7.print(Ex7.trianglePascal(7)));
	}
}
