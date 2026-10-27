package lab3;

import junit.framework.TestCase;

public class Ex2_Test extends TestCase {
public void testEx2() {
	assertEquals(Ex2.countNumber(112345678), 9);
	assertEquals(Ex2.revolveNumber(12345678), "[8, 7, 6, 5, 4, 3, 2, 1]");
}
}
