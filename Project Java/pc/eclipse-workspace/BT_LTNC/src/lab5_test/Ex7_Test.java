package lab5_test;

import junit.framework.TestCase;
import lab5.Ex7;

public class Ex7_Test extends TestCase {
	public void testEx7() {
		assertEquals(Ex7.print(Ex7.trianglePascal(7)), Ex7.strB.toString());
	}
}
