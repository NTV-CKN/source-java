import junit.framework.TestCase;
public class Test extends TestCase{
	
	//testAddressConstructor
	public void testAddressConstructor() {
		Address add = new Address(12, "Hoa Phu", "Phu Hoa");
	}
	//testDescribeHouseConstructor
	public void testDescribeHouseConstructor() {
		new DescribeHouse("Ranch", 12, 123, new Address(1, "Tan Binh", "Tan Binh"));
	}
}
