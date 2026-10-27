package lab5_test;

import junit.framework.TestCase;
import lab5.Ex5;

public class Ex5_Test extends TestCase {
	public void testEx5() {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] b = { { 7, 8, 9 }, { 4, 5, 6 }, { 1, 2, 3 } };
		assertEquals(Ex5.print(Ex5.plusAB(a, b)), Ex5.strB.toString());
		assertEquals(Ex5.print(Ex5.except(a, b)), Ex5.strB.toString());
	}
}
