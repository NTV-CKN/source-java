package lab2;

import junit.framework.TestCase;

public class Ex3_Test extends TestCase {
public void testEx3() {
	assertEquals(Ex3.findX(0, 0), "Phuong trinh vo so nghiem");
	assertEquals(Ex3.findX(0, 1), "Phuong trinh vo nghiem");
	assertEquals(Ex3.findX(2, 5), "-2.5");
	assertEquals(Ex3.findX(2, -5), "2.5");
	
}
}
