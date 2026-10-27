package lab6_test;

import junit.framework.TestCase;
import lab6.Ex11;

public class Ex11_Test extends TestCase {
	public void testEx11() {
		assertEquals(Ex11.countVowel("bcdrg"), 0);
		assertEquals(Ex11.countVowel("Aaueoai"), 7);
	}
}
