package lab3;

import java.util.Scanner;

public class SimulateList {
	public static int[] newArr(int[] arrInt, int count, int number) {
		int newArr[] = new int[count];
		for (int i = 0; i < newArr.length - 1; i++) {
			newArr[i] = arrInt[i];
		}
		newArr[count - 1] = number;
		return newArr;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int number, count = 1, max = 0;
		double total = 0;
		Scanner sc = new Scanner(System.in);
		int[] arrInt = null;

		do {
			System.out.println("Press any numbers to work and 0 to exit");
			number = sc.nextInt();
			if (number != 0) {
				if (arrInt == null) {
					arrInt = new int[count];
					arrInt[0] = number;
				} else {
					++count;
					System.out.println(arrInt[0]);
					arrInt = SimulateList.newArr(arrInt, count, number);
				}
			}
		} while (number != 0);
		if (arrInt != null) {
			for (int i : arrInt) {
				if (max < i) {
					max = i;
				}
				total += i;
			}
		}

		System.out.println("SUM = " + total);
		System.out.println("AVG = " + (total / count));
		System.out.println("MAX = " + max);

		long end = System.currentTimeMillis();
		long runTime = end - start;
		System.out.println(runTime + " ms");
	}
}
