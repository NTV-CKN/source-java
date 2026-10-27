package lab2;

import junit.framework.TestCase;

public class Ex8_Test extends TestCase {
	public void testEx8() {
		assertEquals(Ex8.getYearCanChi(1998), "Mau Dan");
		assertEquals(Ex8.getYearCanChi(2005), "At Dau");
		assertEquals(Ex8.getYearCanChi(2006), "Binh Tuat");
		assertEquals(Ex8.getYearCanChi(2024), "Giap Thin");
	}
}
