package lab6_test;

import junit.framework.TestCase;
import lab6.Ex13;

public class Ex13_Test extends TestCase {
	public void testEx13() {
		assertEquals(Ex13.isAnagram("Anh hai", "Anh hai"), true);
		assertEquals(Ex13.isAnagram("Anh hai", "anh hai"), false);
	}
}
