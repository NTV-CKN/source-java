package Ex_6_5;

import junit.framework.TestCase;

public class ILogTest extends TestCase {
	public void test() {
		Date d1 = new Date(12, 1, 2005);
		Date d2 = new Date(1, 1, 2005);
		Date d3 = new Date(11, 4, 2005);
		Date d4 = new Date(12, 5, 2005);
		
		Entry e1 = new Entry(d1, 12, 2, "Good", 12);
		Entry e2 = new Entry(d2, 5, 1, "Good", 132);
		Entry e3 = new Entry(d3, 22, 4, "Normal", 1);
		Entry e4 = new Entry(d4, 42, 6, "Tired", 9);
		

		ILog iLog1 = new ConsILog(e1, new ConsILog(e2, new ConsILog(e3, new ConsILog(e4, new EmptyILog()))));
		ILog iLog2 = new EmptyILog();
		//sameMonthInAYear
		assertEquals(d1.sameMonthInAYear(1, 2005), true);
		assertEquals(d2.sameMonthInAYear(1, 2004), false);
		//getDistance
		assertEquals(e1.getDistance(), 12.0);
		assertEquals(e4.getDistance(), 42.0);
		//miles
		assertEquals(iLog1.miles(), 81.0);
		assertEquals(iLog2.miles(), 0.0);
		//getLogs
		System.out.println(iLog1.getLogs(1, 2005));
		System.out.println("==================");
		System.out.println(iLog1.getLogs(4, 2005));
		System.out.println("==================");
		//maxDistance
		assertEquals(iLog1.maxDistance(), 42.0);
		assertEquals(iLog2.maxDistance(), 0.0);

		//sort
		System.out.println(iLog1.sort());
		//ILog dsN = new ConsILog(e2, new ConsILog(e1, new ConsILog(e4, new ConsILog(e3, new EmptyILog()))));
		//assertEquals(dsN, iLog1.sort());
	}
}
