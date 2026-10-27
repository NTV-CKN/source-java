package Ex_5_5;

import junit.framework.TestCase;

public class ILogTest extends TestCase {
	public void test() {
		Date d1 = new Date(12, 1, 2005);
		Date d2 = new Date(1, 1, 2005);
		Date d3 = new Date(11, 4, 2005);
		Date d4 = new Date(12, 5, 2005);
		
		Entry e1 = new Entry(d1, 12, 2, "Good");
		Entry e2 = new Entry(d2, 5, 1, "Good");
		Entry e3 = new Entry(d3, 22, 4, "Normal");
		Entry e4 = new Entry(d4, 42, 6, "Tired");
		
		ILog iLog1 = new ConsILog(e1, new ConsILog(e2, new ConsILog(e3, new ConsILog(e4, new EmptyILog()))));
		ILog iLog2 = new EmptyILog();
		//sameMonthInAYear
		assertEquals(d1.sameMonthInAYear(1, 2005), true);
		assertEquals(d2.sameMonthInAYear(1, 2004), false);
		//getDistance
		assertEquals(e1.getDistance(), 12.0);
		assertEquals(e4.getDistance(), 42.0);
		//miles
		assertEquals(iLog1.miles(d1), 17.0);
		assertEquals(iLog2.miles(d2), 0.0);
		//getLogs
		System.out.println(iLog1.getLogs(1, 2005));
		System.out.println("==================");
		System.out.println(iLog1.getLogs(4, 2005));
		//maxDistance
		assertEquals(iLog1.maxDistance(), 42.0);
		assertEquals(iLog2.maxDistance(), 0.0);
		//sort
		System.out.println("Ban dau: "+"\n"+iLog1);
		System.out.println("=========================");
		System.out.println("sau: "+"\n"+iLog1.sortByDuration());
		
	}
}
