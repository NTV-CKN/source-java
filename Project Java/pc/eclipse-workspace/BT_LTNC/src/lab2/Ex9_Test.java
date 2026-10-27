package lab2;

import junit.framework.TestCase;

public class Ex9_Test extends TestCase {
	public void testEx9() {
		assertEquals(Ex9.returnString(125), "mot tram hai muoi lam");
		assertEquals(Ex9.returnString(901), "chin tram le mot");
		assertEquals(Ex9.returnString(950), "chin tram nam muoi");
		assertEquals(Ex9.returnString(11), "muoi mot");

	}
}
