package lab2;

import junit.framework.TestCase;

public class Ex4_Test extends TestCase {
	public void testEx4() {
		assertEquals(Ex4.solveQuadratic(0, 0, 0), "Phuong trinh bac mot vo so nghiem");
		assertEquals(Ex4.solveQuadratic(1, -5, 2), "Phuong trinh co 2 nghiem phan biet: x1 = 4.56, x2 = 0.43");
		assertEquals(Ex4.solveQuadratic(2, 1, -6), "Phuong trinh co 2 nghiem phan biet: x1 = 1.5, x2 = -2.0");
		assertEquals(Ex4.solveQuadratic(0, 2, 5), "Phuong trinh bac mot va co nghiem la: -2.5");
	}
}
