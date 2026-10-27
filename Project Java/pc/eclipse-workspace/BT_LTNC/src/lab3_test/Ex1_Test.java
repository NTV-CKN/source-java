package lab3_test;
import lab3.Ex1;
import junit.framework.TestCase;

public class Ex1_Test extends TestCase {
	public void testEx1() {
		assertEquals(Ex1.solve(), Ex1.answer);
	}
}
