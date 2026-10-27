package lab4_test;

import junit.framework.TestCase;
import lab4.Ex9;

public class Ex9_Test extends TestCase {
	public void testEx9() {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 9 }, { 3, 4, 5, 6 } };
		assertEquals(Ex9.solveSquareMatrix(arr), "Row 0 :10\n" + "Row 1 :27\n" + "Row 2 :18\n" + "27");
	}
}
