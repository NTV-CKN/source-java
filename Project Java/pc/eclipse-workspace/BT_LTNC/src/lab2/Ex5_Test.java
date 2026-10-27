package lab2;

import junit.framework.TestCase;

public class Ex5_Test extends TestCase {
public void testEx5() {
	assertEquals(Ex5.findLengthIAndU(-2, 3, 1, 6), "Length of Insection: 2, length of union: 8");
	assertEquals(Ex5.findLengthIAndU(1, 4, 3, 6), "Length of Insection: 1, length of union: 5");
	assertEquals(Ex5.findLengthIAndU(1, 2, 5, 8), "Length of Insection: 0, length of union: 4");
}
}
