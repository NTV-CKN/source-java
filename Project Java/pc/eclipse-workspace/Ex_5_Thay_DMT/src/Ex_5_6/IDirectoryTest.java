package Ex_5_6;

import junit.framework.TestCase;

public class IDirectoryTest extends TestCase {
	public void test() {
		//khoi tao PhoneDirectory
		PhoneDirectory p1 = new PhoneDirectory("Nguyen Truong Vu", "0123456789");
		PhoneDirectory p2 = new PhoneDirectory("Nguyen Lam Vu", "123321234");
		PhoneDirectory p3 = new PhoneDirectory("Nguyen Tuong Vy", "56789987675");
		PhoneDirectory p4 = new PhoneDirectory("Nguyen Truong Han", "987654321");
		//khoi tao IDirectory
		IDirectory ds1 = new ConsIDirectory(p1, new ConsIDirectory(p2, new ConsIDirectory(p3, new ConsIDirectory(p4, new EmptyIDirectory()))));
		IDirectory ds2 = new EmptyIDirectory();
		//whoseNumber
		assertEquals(ds1.whoseNumber("0123456789"), p1);
		assertEquals(ds1.whoseNumber("0123456"), null);
		assertEquals(ds1.whoseNumber("987654321"), p4);
		//phoneNumber
		assertEquals(ds1.phoneNumber("Nguyen Truong Han"), p4);
		assertEquals(ds2.phoneNumber("Nguyen Truong Han"), null);
		assertEquals(ds1.phoneNumber("Nguyen Tuong Vy"), p3);
		
		
	}
}
