package lab3;

import junit.framework.TestCase;

public class Ex4_Test extends TestCase {
	public void testEx4() {
		// Test 1
		assertEquals(Ex4.getGcd(1, 12), 1);
		assertEquals(Ex4.getLcm(1, 12), 12);
		// Test 2
		assertEquals(Ex4.getGcd(21, 1000), 1);
		assertEquals(Ex4.getLcm(21, 1000), 21000);
	}
}
