package ex_1;
import junit.framework.*;
public class TestMethod extends TestCase{
	public void testHouse() {
		House house1 = new House("Ranch", 7, new Address("23", "Mapple Street", "Brooklyn"), 375000);

				House house2 = new House("Colonial", 9,
				new Address("5", "Jove Road", "Newton"), 450000);

				House house3 = new House("Cape", 6,
				new Address("83", "Winslow Road", "Waltham"), 235000);

				//hasMoreRooms
				assertFalse(house1.hasMoreRooms(house2));
				assertTrue(house2.hasMoreRooms(house3));
				//inThisCity
				assertTrue(house1.inThisCity("Brooklyn"));
				assertFalse(house1.inThisCity("Newton"));
				//sameCity
				assertTrue(house1.sameCity(house1));
				assertFalse(house1.sameCity(house2));
	}
}
