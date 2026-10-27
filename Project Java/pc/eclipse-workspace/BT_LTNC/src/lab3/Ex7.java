package lab3;

public class Ex7 {
	public static String mutiplicationTable;

	public static String printTimesTable() {
		StringBuilder strB = new StringBuilder();
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 11; j++) {
				if (j == 6) {
					strB.append("\n");
				}
				strB.append(i + "x" + j + " = " + (i * j) + "\t");
			}
			strB.append("\n\n");
		}
		mutiplicationTable = strB.toString();
		return strB.toString();
	}

	public static void main(String[] args) {
		System.out.println(Ex7.printTimesTable());
	}
}
