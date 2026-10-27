package lab1;

import junit.framework.TestCase;

public class Ex4_Test extends TestCase {
	public void testEx4() {
		assertEquals(Ex4.areaCircleAndPerimeter(1), "Dien tich hinh tron la: 3.14\n" + "Chu vi hinh tron la: 6.28");
		assertEquals(Ex4.areaCircleAndPerimeter(0), "Dien tich hinh tron la: 0.0\n" + "Chu vi hinh tron la: 0.0");
		assertEquals(Ex4.areaCircleAndPerimeter(-4), "Thong so ban kinh khong hop le");
	}
}
