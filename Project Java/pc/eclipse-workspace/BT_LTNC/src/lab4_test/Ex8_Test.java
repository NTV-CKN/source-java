package lab4_test;

import junit.framework.TestCase;
import lab4.Ex8;

public class Ex8_Test extends TestCase {
	public void testEx8() {
		int[][] arr = { { 2, 3, 4, 5 }, { 5, 6, 7, 8 }, { 1, 2, 3, 4 } };
		assertEquals(Ex8.findMN(arr), "The min value: 1, the max value: 8");
		assertEquals(Ex8.sumMatrix(arr), 50);
	}
}
