package lab4_test;

import junit.framework.TestCase;
import lab4.Ex2;

public class Ex2_Test extends TestCase {
	public void testEx2() {
		int[] arr = { 1, 2, 4, 9, 7, 9, 9, 9, 9, 2 };
		assertEquals(Ex2.countAppearMaxE(arr), 5);
	}
}
