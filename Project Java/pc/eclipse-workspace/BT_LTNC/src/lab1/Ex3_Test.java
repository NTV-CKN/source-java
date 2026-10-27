package lab1;

import junit.framework.TestCase;

public class Ex3_Test extends TestCase {
	public void testEx3() {
		assertEquals(Ex3.changeMilesToKm(5.0), "5.0 miles change to km is: 8.045");
		assertEquals(Ex3.changeMilesToKm(0), "0.0 miles change to km is: 0.0");
		assertEquals(Ex3.changeMilesToKm(9.2), "9.2 miles change to km is: 14.8028");
		assertEquals(Ex3.changeMilesToKm(-5), "So miles cua ban khong hop le");
	}
}
