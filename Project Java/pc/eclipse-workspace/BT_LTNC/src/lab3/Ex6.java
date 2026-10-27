package lab3;

public class Ex6 {
	public static String result = "";
	public static String printCorner() {
		StringBuilder strB = new StringBuilder();
		strB.append("Corner\tCos\tSin\ttan\tcot\n");
		int count = 0;
		double cos, sin, tan, cot;
		while (count >= 0 && count <= 90) {
			cos = Math.cos(count);
			sin = Math.sin(count);
			tan = sin / cos;
			cot = 1 / tan;
			strB.append(count + "\t" + cos + "\t" + sin + "\t" + tan + "\t" + cot + "\n");
			count += 5;
		}
		result = strB.toString();
		return strB.toString();
	}

	public static void main(String[] args) {
		System.out.println(Ex6.printCorner());
	}
}
