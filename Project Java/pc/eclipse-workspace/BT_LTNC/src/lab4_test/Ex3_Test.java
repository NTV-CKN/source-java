package lab4_test;

import junit.framework.TestCase;
import lab4.Ex3;

public class Ex3_Test extends TestCase {
	public void testEx3() {
		int arr[] = { 1, 5, -1, -4, 0, 0, 0, 3, -4 };
		assertEquals(Ex3.countPosNegZero(arr), "Amount: positive: 3, negative: 3, zero: 3");
		assertEquals(Ex3.findMaxValue(arr), 5);
		assertEquals(Ex3.findMinValue(arr), -4);
		assertEquals(Ex3.isSumSame(arr), true);
	}
}
