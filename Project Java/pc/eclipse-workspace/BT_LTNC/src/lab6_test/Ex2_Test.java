package lab6_test;

import junit.framework.TestCase;
import lab6.Ex2;

public class Ex2_Test extends TestCase {
	public void testEx2() {
		assertEquals(Ex2.isPalindrome("level"), true);
		assertEquals(Ex2.isPalindrome("vu"), false);
	}
}
