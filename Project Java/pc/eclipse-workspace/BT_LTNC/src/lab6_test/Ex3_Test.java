package lab6_test;

import junit.framework.TestCase;
import lab6.Ex3;

public class Ex3_Test extends TestCase {
	public void testEx3() {
		assertEquals(Ex3.countVC("xin chao cac ban"), "Amount vowels: 5, consonants: 11");
	}
}
