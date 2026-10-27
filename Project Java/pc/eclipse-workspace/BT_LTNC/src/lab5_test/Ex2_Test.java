package lab5_test;

import junit.framework.TestCase;
import lab5.Ex2;

public class Ex2_Test extends TestCase {
	public void testEx3() {
		int[][] arr = { { 1, 2, 3 }, { 0, 4, 5 }, { 0, 0, 6 } };
		int[][] arr2 = { { 1, 2, 3 }, { 2, 4, 5 }, { 3, 5, 6 } };
		assertEquals(Ex2.checkMainDiagonal(arr, 3), true);
		assertEquals(Ex2.isTriangleMatrix(arr), true);
		assertEquals(Ex2.checkSymmetrySquareMatrix(arr2), true);
		assertEquals(Ex2.checkThroghMind(arr2), false);
	}
}
