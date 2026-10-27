package lab6_test;

import junit.framework.TestCase;
import lab6.Ex14;

public class Ex14_Test extends TestCase {
	public void testEx14() {
		assertEquals(Ex14.removeWhiteSpace("Nguyen Truong Vu "), "NguyenTruongVu");
	}
}
