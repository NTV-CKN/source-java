package lab6_test;

import junit.framework.TestCase;
import lab6.Ex10;

public class Ex10_Test extends TestCase {
	public void testEx10() {
		assertEquals(Ex10.isDigit("Nguyen 123"), false);
		assertEquals(Ex10.isDigit("1234567890"), true);
	}
}
