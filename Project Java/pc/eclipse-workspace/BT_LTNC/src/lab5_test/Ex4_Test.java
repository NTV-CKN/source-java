package lab5_test;

import junit.framework.TestCase;
import lab5.Ex4;

public class Ex4_Test extends TestCase {
	public void testEx4() {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 9 }, { 3, 4, 5, 6 } };
		assertEquals(Ex4.solveSquareMatrix(arr), Ex4.strB.toString());
	}
}
