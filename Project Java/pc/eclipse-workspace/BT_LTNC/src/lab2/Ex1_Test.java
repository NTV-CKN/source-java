package lab2;

import junit.framework.TestCase;

public class Ex1_Test extends TestCase {
public static void testEx1() {
	assertEquals(Ex1.findMax(2, 3), 3.0);
	assertEquals(Ex1.findMax(3, 3), 3.0);
	assertEquals(Ex1.findMax(3, 2), 3.0);
	assertEquals(Ex1.findMax(-2, -3), -2.0);
	
}
}
