package lab6_test;

import junit.framework.TestCase;
import lab6.Ex5;

public class Ex5_Test extends TestCase {
	public void testEx5() {
		assertEquals(Ex5.isAnagram("Anh hai", "Anh hai"), true);
		assertEquals(Ex5.isAnagram("Anh hai", "anh hai"), false);
	}
}
