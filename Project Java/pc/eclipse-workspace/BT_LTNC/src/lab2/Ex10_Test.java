package lab2;

import junit.framework.TestCase;

public class Ex10_Test extends TestCase {
public void testEx10() {
	assertEquals(Ex10.checkFormat(21, 14, 2000), "Numbers don't correct format d/m/y");
	assertEquals(Ex10.checkFormat(-1, 0, 0), "Don't accept");
	assertEquals(Ex10.checkFormat(29, 2, 1996), "1/3/1996");
	assertEquals(Ex10.checkFormat(28, 2, 1997), "1/3/1997");
	assertEquals(Ex10.checkFormat(30, 3, 2024), "31/3/2024");
	assertEquals(Ex10.checkFormat(31, 12, 2005), "1/1/2006");
}
}
