package Ex_2_5;
import junit.framework.*;
public class TestMethod extends TestCase{
	public void testJetFuelMethod() {
		//khoi tao
	 	JetFuel jf_1 = new JetFuel(150000, 200, "High");
	 	JetFuel jf_2 = new JetFuel(100000, 200, "Normal");
	 	//totalCost()
	 	assertEquals( jf_1.totalCost(), 30000000);
	 	assertEquals(jf_2.totalCost(), 20000000);
	 	//discountSold()
	 	assertEquals(jf_1.discountSold(),27000000.0);
	 	assertEquals(jf_2.discountSold(), 20000000.0);
	}
}
