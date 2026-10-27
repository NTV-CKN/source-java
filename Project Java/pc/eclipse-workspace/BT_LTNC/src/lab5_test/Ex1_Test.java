package lab5_test;

import lab5.Ex1;
import junit.framework.TestCase;

public class Ex1_Test extends TestCase {
	public void testEx1() {
		int[][] arr = { { 2, 3, 4, 5 }, { 5, 6, 7, 8 }, { 1, 2, 3, 4 } };
		assertEquals(Ex1.findMN(arr), "The min value: 1, the max value: 8");
		assertEquals(Ex1.sumMatrix(arr), 50);
	}
}
