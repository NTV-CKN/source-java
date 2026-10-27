package lab3_test;
import lab3.Ex5;
import junit.framework.TestCase;

public class Ex5_Test extends TestCase {
	public void testEx5() {
		assertEquals(Ex5.findOddMajorBiggest(7), 1);
		assertEquals(Ex5.isPrime(31), true);
		assertEquals(Ex5.primeNumbers(72), "2 2 2 9");
		assertEquals(Ex5.lookForPrimesNumber(19), "2, 3, 5, 7, 11, 13, 17");
	}
}
