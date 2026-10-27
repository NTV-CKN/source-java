package lab6_test;

import junit.framework.TestCase;
import lab6.Ex16;

public class Ex16_Test extends TestCase {
	public void testEx16() {
		assertEquals(Ex16.isPalindrome("level"), true);
		assertEquals(Ex16.isPalindrome("vu"), false);
	}
}
