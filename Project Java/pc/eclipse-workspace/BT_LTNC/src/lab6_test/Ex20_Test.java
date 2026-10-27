package lab6_test;

import junit.framework.TestCase;
import lab6.Ex20;

public class Ex20_Test extends TestCase {
	public void testEx20() {
		assertEquals(Ex20.removeSC("nguyen truong @ *&%$## dsscs"), "nguyentruongdsscs");
	}
}
