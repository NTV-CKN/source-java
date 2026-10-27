package Ex_2_1_1_change;
import Ex_2_1_change.Employee;
import junit.framework.*;
public class TestMethod extends TestCase{
	public void testEmployeeExMethod() {
		//netPayWithRate
		 assertEquals(new EmployeeEx("Nguyen Truong Vu", 12).netpayWithRate(12), 144, 0.1);
		 assertEquals(new EmployeeEx("Nguyen Tuong Vy", 23).netpayWithRate(12), 234.6, 0.1);
		 //taxWithRate
		 assertEquals(new EmployeeEx("Nguyen Truong Vu", 12).taxWithRate(12), 0, 0.1);
		 assertEquals(new EmployeeEx("Nguyen Tuong Vy", 23).taxWithRate(12), 41.4, 0.1);
	}
}
