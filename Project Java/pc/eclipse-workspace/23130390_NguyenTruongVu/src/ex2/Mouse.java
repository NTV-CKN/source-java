package ex2;

/*
 *   co the de sau sinh = 50
      chu ki mang thai = 20
       co the mang thai tiep sau = 27
       so luong luc de = 5
 */
public class Mouse {
	public static int estimate(int days) {
		if (days < (50 + 20)) {
			return 1;// chua du truong thanh va chu ki thai
		}
		return cal(days - 70) * 5 + 5;
	}

	private static int cal(int days) {
		if (days < 47) {
			return 0;
		}
		return cal(days - 47) + 1;
	}
	public static void main(String[] args) {
		System.out.println(estimate(50));
		System.out.println(estimate(70));
		System.out.println(estimate(97));
		System.out.println(estimate(120));
		System.out.println(estimate(200));
	}
}
