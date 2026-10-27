package lab4_test;

import junit.framework.TestCase;
import lab4.Ex7;

public class Ex7_Test extends TestCase {
	public void testEx7() {
		int[] arr1 = { 4, 2, 7, 3, 7, 2, 4 };
		int[] arr2 = { 2, -1, 7, -3, 4, -7, 4 };
		assertEquals(Ex7.isSymmetry(arr1), true);
		assertEquals(Ex7.isIntertwined(arr2), true);
	}
}
