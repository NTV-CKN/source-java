package lab1;

import junit.framework.TestCase;

public class Ex2_Test extends TestCase {
	public void testEx2() {
		assertEquals(Ex2.findY(0), 8);
		assertEquals(Ex2.findY(7), 36);
		assertEquals(Ex2.findY(-23), -84);
	}
}
