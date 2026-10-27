package lab3;

public class Ex3 {
	public static int findAgeDouble() {
		int father = 35;
		int son = 4;
		while (true) {
			if ((son * 2) == father) {
				return son - 4;
			}
			father++;
			son++;
		}
	}
	public static void main(String[] args) {
		System.out.println(findAgeDouble());
	}
}
