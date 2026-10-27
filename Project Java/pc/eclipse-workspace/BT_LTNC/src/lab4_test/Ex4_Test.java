package lab4_test;

import junit.framework.TestCase;
import lab4.Ex4;

public class Ex4_Test extends TestCase {
	public void testEx4() {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		assertEquals(Ex4.printArrayReverve(arr), "[7, 6, 5, 4, 3, 2, 1]");
	}
}
