package lab1;

import junit.framework.TestCase;

public class Ex5_Test extends TestCase {
	public void testEx5() {
		assertEquals(Ex5.changeTime(1999), "0:33:19");
		assertEquals(Ex5.changeTime(0), "0:0:0");
		assertEquals(Ex5.changeTime(-2), "Tong so gio khong hop le");
	}
}
