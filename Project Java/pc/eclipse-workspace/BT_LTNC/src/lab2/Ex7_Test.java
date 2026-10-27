package lab2;

import junit.framework.TestCase;

public class Ex7_Test extends TestCase {
	public void testEx7() {
		assertEquals(Ex7.checkTriangle(0, 1, 3), "Formatting don't suit");
		assertEquals(Ex7.checkTriangle(3, 2, 4), "Scalene triangle");
		assertEquals(Ex7.checkTriangle(3, 3, 4), "Right isosceles triangle");
		assertEquals(Ex7.checkTriangle(3, 3, 3), "Equilateral triangle");
		assertEquals(Ex7.checkTriangle(1, 2, 3), "Don't accept");
	}
}
