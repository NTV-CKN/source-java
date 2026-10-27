package lab4_test;

import junit.framework.TestCase;
import lab4.Ex1;

public class Ex1_Test extends TestCase {
	public void testEx1() {
		int[] arr = { 1, 4, 7, 2, 3, 9, 12 };
		assertEquals(Ex1.findMaxOfArray(arr), "The max value: 12, at 6");
		assertEquals(Ex1.findMinOfArray(arr), "The min value: 1, 0");
		assertEquals(Ex1.sumOfArray(arr), 38);
	}
}
