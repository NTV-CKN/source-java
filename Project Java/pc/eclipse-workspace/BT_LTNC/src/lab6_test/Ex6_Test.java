package lab6_test;

import junit.framework.TestCase;
import lab6.Ex6;

public class Ex6_Test extends TestCase {
	public void testEx6() {
		assertEquals(Ex6.removeWhiteSpace("Nguyen Truong Vu "), "NguyenTruongVu");
	}
}
