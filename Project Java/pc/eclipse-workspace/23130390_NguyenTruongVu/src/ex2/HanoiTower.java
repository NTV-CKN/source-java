package ex2;

/*
 * cach thuc hoat dong:
 * 	+lan goi de quy dau tien se duyet den n = 1 (param di vao la n - 1) va tra ve diem source -> destination
 * 	+sau do ta luu diem source -> destination cua n
 * 	+lan goi 2 se di chuyen tu diem trung gian den diem dich
 * vi du ta co 3 cot A, B, C va co 3 vong, voi thuat toan tren thi no se hoat dong nhu sau:
 * 	+n = 3 se goi de quy ve n = 2, n = 3 co so thu tu cot la ABC, n = 2 la ACB
 * 	+n = 2 lai goi n = 1, n = 2 la ACB, n = 1 la ABC
 * 	+n = 1 la dieu kien stop cua de quy nen tra ve A -> C, sau do n = 2 luu lai diem A - >B
 * 	+n = 2 lai goi n = 1, n = 1 co thu tu la CAB nen tra ve C -> B => n3 = A, n1=n2=B
 * 	+n = 3 se luu A -> C, sau do goi tiep n = 2 voi thu tu BAC
 * 	+n = 2 goi n = 1, n = 2 thu tu BAC, n = 1 thu tu BCA
 * 	+n = 1 luu B -> A, n = 2 luu B -> C va goi lai n = 1 thu tu ABC => n1=n2=n3=C
 */
public class HanoiTower {
	//dung StringBuilder khien exception khi number > 5
	static StringBuilder strB = new StringBuilder();

	// n = nguon, t = trung gian, d = dich
	public static String hanoiTower(int number, char n, char t, char d) {
		if (number == 1) {
			return n + "->" + d;
		}
		strB.append("Number " + number + " cua " + (number - 1) + " " + hanoiTower(number - 1, n, d, t) + "\n");
		strB.append("Number: " + number + " " + n + "->" + d + "\n");
		strB.append("Number " + number + " cua " + (number - 1) + " " + hanoiTower(number - 1, t, n, d) + "\n");
		return strB.toString();
	}
	public static void main(String[] args) {
		System.out.println(hanoiTower(3, 'A', 'B', 'C'));
	}
}
