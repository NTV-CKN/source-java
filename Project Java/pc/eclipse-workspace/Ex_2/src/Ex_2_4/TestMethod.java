package Ex_2_4;
import junit.framework.*;
public class TestMethod extends TestCase{
	public void testCoffeeMethod() {
		Coffee cf_1 = new Coffee("Chon", 2000, 2.3);
		Coffee cf_2 = new Coffee("Muoi", 2000, 23.4);
		
		//cost
		assertEquals(cf_1.cost(), 4600.0);
		assertEquals(cf_2.cost(), 46800.0);
		//pay
		assertEquals(cf_1.pay(), 4600.0);
		assertEquals(cf_2.pay(), 35100.0);
	}
}
