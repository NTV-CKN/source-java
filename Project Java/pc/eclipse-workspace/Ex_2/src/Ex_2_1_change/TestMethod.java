package Ex_2_1_change;
import junit.framework.*;
public class TestMethod extends TestCase{
	public void testEmployeeMethod() {
		 new Employee("Nguyen Truong Vu", 12);
		 new Employee("Nguyen Tuong Vy", 23);
		 
		 //wage()
		 assertEquals(new Employee("Nguyen Truong Vu", 12).getWage(12), 144.0);
		 assertEquals(new Employee("Nguyen Tuong Vy", 23).getWage(12), 276.0);
		 //tax()
		 assertEquals(new Employee("Nguyen Truong Vu", 12).tax(0.15, 12), 21.6, 0.1);
		 assertEquals(new Employee("Nguyen Tuong Vy", 23).tax(0.15 , 12), 41.4, 0.1);
		 //netPay()
		 assertEquals(new Employee("Nguyen Truong Vu", 12).netPay(0.15, 12), 122.4, 0.1);
		 assertEquals(new Employee("Nguyen Tuong Vy", 23).netPay(0.15, 12), 234.6, 0.1);
		 //raisedWage()
		 assertEquals(new Employee("Nguyen Truong Vu", 12).raisedWage(12), 158.0, 0.1);
		 assertEquals(new Employee("Nguyen Tuong Vy", 23).raisedWage(12), 290.0, 0.1);
		 //checkOverTime()
		 assertTrue(new Employee("Nguyen Truong Vu", 12).checkOverTime());
		 assertFalse(new Employee("Nguyen Tuong Vy", 23).checkOverTime());
	}
}
