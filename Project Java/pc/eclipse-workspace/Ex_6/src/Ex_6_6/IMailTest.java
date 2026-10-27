package Ex_6_6;

import junit.framework.TestCase;

public class IMailTest extends TestCase {
public void test() {
	Date date1 = new Date(12, 12, 2003);
	Date date2 = new Date(1, 12, 2003);
	Date date3 = new Date(12, 12, 2005);
	Date date4 = new Date(12, 12, 2003);
	
	Mail m1 = new Mail("Vu", "Hello", date1);
	Mail m2 = new Mail("Dat", "Hi there", date2);
	Mail m3 = new Mail("Vy", "Nice to meet you", date3);
	Mail m4 = new Mail("Tuyen", "How are you?", date4);
	
	IMail ds1 = new ConsMail(m1, new ConsMail(m2, new ConsMail(m3, new ConsMail(m4, new EmptyMail()))));
	IMail ds2 = new EmptyMail();
	System.out.println("Before");
	System.out.println(ds1);
	System.out.println("After");
	System.out.println(ds1.sort());
}
}
