package lab2;

import junit.framework.TestCase;

public class Ex6_Test extends TestCase {
public void testEx6() {
	assertEquals(Ex6.solve(3, 3, 4), "Perimeter of a triangle: 10.0, area: 4.47, corner A: 0.84");
	assertEquals(Ex6.solve(-1, 0, 0), "Canh tam giac khong duoc am");
	assertEquals(Ex6.solve(1, 2, 3), "Thong so khong hop le");
}
}
