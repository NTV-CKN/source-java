package lab4_test;

import junit.framework.TestCase;
import lab4.Ex10;

public class Ex10_Test extends TestCase {
	public void testEx10() {
		int[][] arr = { { 1, 2, 3 }, { 0, 4, 5 }, { 0, 0, 6 } };
		int[][] arr2 = { { 1, 2, 3 }, { 2, 4, 5 }, { 3, 5, 6 } };
		assertEquals(Ex10.checkMainDiagonal(arr, 3), true);
		assertEquals(Ex10.isTriangleMatrix(arr), true);
		assertEquals(Ex10.checkSymmetrySquareMatrix(arr2), true);
		assertEquals(Ex10.checkThroghMind(arr2), false);
	}
}
