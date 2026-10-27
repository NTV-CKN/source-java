package lab1;

import junit.framework.TestCase;

public class Ex1_Test extends TestCase {
	public void testEx1() {
		assertEquals(Ex1.multiple(2, 2.3f), 4.6f);
		assertEquals(Ex1.multiple(0, 0.0f), 0.0f);
		assertEquals(Ex1.multiple(-2, 2.3f), -4.6f);
	}
}
