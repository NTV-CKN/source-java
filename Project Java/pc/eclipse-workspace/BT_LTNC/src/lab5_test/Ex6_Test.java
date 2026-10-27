package lab5_test;

import junit.framework.TestCase;
import lab5.Ex6;

public class Ex6_Test extends TestCase {
	public void testEx6() {
		int[][] a = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		int[][] b = { { 7, 8, 9 }, { 10, 11, 12 } };
		assertEquals(Ex6.print(Ex6.multiply(a, b)), Ex6.strB.toString());
	}
}
