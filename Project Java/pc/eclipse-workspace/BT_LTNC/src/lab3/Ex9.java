package lab3;

public class Ex9 {
	public static double amount(double sendMoney, double interestPerMonth, double numberSendMonth) {
		return (int) (sendMoney * Math.pow((1 + interestPerMonth), numberSendMonth) * 100) / 100.0;
	}

	public static void main(String[] args) {
		System.out.println(Ex9.amount(2000000, 0.01, 3));// 2060602.0
		System.out.println(Ex9.amount(100000, 0.01, 12));// 112682.5
	}
}
