package lab2;

import junit.framework.TestCase;

public class Ex2_Test extends TestCase {
	public void testEx2() {
		// a)
		assertEquals(Ex2.checkLeapYear(2001), false);
		assertEquals(Ex2.checkLeapYear(2004), true);
		assertEquals(Ex2.checkLeapYear(2008), true);
		// b)
		assertEquals(Ex2.getDaysInMonth(3, 2024), "Thang 3, nam 2024 co so ngay la: 31");
		assertEquals(Ex2.getDaysInMonth(2, 2024), "Thang 2, nam 2024 co so ngay la 29");
		assertEquals(Ex2.getDaysInMonth(5, 2024), "Thang 5, nam 2024 co so ngay la: 31");
	}
}
