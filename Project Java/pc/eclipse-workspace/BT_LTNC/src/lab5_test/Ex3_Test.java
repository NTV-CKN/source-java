package lab5_test;

import junit.framework.TestCase;
import lab5.Ex3;

public class Ex3_Test extends TestCase {
	public void testEx3() {
		int[][] arr1 = { { 2, 3, 4 }, { 5, 6, 7 }, { 1, 2, 3 } };
		int[][] arr2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		assertEquals(Ex3.printMatrix(Ex3.transfer(arr1)), Ex3.strB.toString());
		assertEquals(Ex3.printMatrix(Ex3.positionChange(arr2)), Ex3.strB.toString());
	}
}
