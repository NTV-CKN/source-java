package lab3_test;
import lab3.Ex9;
import junit.framework.TestCase;

public class Ex9_Test extends TestCase {
	public void testEx9() {
		assertEquals(Ex9.amount(2000000, 0.01, 3), 2060602.0);
		assertEquals(Ex9.amount(1300000, 0.01, 12), 1464872.53);
	}
}
