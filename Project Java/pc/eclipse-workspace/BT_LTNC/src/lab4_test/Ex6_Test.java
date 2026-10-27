package lab4_test;

import junit.framework.TestCase;
import lab4.Ex6;

public class Ex6_Test extends TestCase {
	public void testEx6() {
		int arr[] = { 2, 1, 3, 1, 6, 5 };
		assertEquals(Ex6.isAscArray(arr), false);
		assertEquals(Ex6.printArraySorted(arr), "[1, 1, 2, 3, 5, 6]");
	}
}
