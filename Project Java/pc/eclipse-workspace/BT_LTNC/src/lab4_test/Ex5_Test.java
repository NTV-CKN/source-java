package lab4_test;

import junit.framework.TestCase;
import lab4.Ex5;

public class Ex5_Test extends TestCase {
	public void testEX5() {
		int arr[] = { 7, 1, 2, 3, 4, 1, 2, 1, 7 };
		assertEquals(Ex5.isExistX(arr, 7), true);
		assertEquals(Ex5.xAtIndex(arr, 1), "Amount x: 2, at index: 0 8");
		assertEquals(Ex5.printArrayNotExistX(arr, 7),
				"[7, 1, 2, 3, 4, 1, 2, 1, 7]" + "\n" + "[1, 2, 3, 4, 1, 2, 1, -2147483648, -2147483648]");
	}
}
