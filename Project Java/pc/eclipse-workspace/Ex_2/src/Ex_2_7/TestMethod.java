package Ex_2_7;
import junit.framework.*;
public class TestMethod extends TestCase{
	public void testTransactionMethod() {
		//khoi tao
		Transaction t1 = new Transaction("Thuy", 6000, 2);
		Transaction t2 = new Transaction("Mai", 2500, 1);
		Transaction t3 = new Transaction("Nam", 1500, 2);
		Transaction t4 = new Transaction("Tien", 500, 2);
		//interest()
		assertEquals(300.0, t1.interest(), 0.001);
		assertEquals(112.5, t2.interest(), 0.001);
		assertEquals(67.5, t3.interest(), 0.001);
		assertEquals(20.0, t4.interest(), 0.001);
		//payBack()
		assertEquals(48.75, t1.payBack(), 0.001);
		assertEquals(13.75, t2.payBack(), 0.001);
		assertEquals(6.25, t3.payBack(), 0.001);
		assertEquals(1.25, t4.payBack(), 0.001);
	}
}
